package main;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import tmxLoader.*;
import main.Map;
import main.MainMenu;

public class GameView {

	private AnchorPane gamePane;
	private Scene gameScene;
	private Stage gameStage;
	private Stage menuStage;
	private ImageView robot;
	
	private boolean IsWKeyPressed;
	private boolean IsAKeyPressed;
	private boolean IsSKeyPressed;
	private boolean IsDKeyPressed;
	private boolean IsMKeyPressed;
	private boolean IsRKeyPressed;
	private AnimationTimer GameTimer;
	private int turn;

	private final static String TILE_SET_FILE_NAME = "RoBoRally.tsx";
	private final static int MAP_INDENT = 15;
	private Map map;
	private int tileSize;
	private Robot[] robots;
	private int activeRobotIndex;
	private int robotsFinished;
	private Robot activeRobot;
	private boolean stop;
	private Label labelTurnCount;

	public GameView() {

		initializeStage();
		createKeyListeners();
	}

	/**
	 * Handle user input
	 */

	private void createKeyListeners() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if ((event.getCode() == KeyCode.W)  || (event.getCode() == KeyCode.UP)) {
					IsWKeyPressed = true;
				} else if ((event.getCode() == KeyCode.S) || (event.getCode() == KeyCode.DOWN)) {
					IsSKeyPressed = true;
				} else if ((event.getCode() == KeyCode.D)  || (event.getCode() == KeyCode.RIGHT)) {
					IsDKeyPressed = true;
				} else if ((event.getCode() == KeyCode.A)  || (event.getCode() == KeyCode.LEFT)) {
					IsAKeyPressed = true;
				} else if (event.getCode() == KeyCode.M) {
					IsMKeyPressed = true;
				} else if (event.getCode() == KeyCode.R) {
					IsRKeyPressed = true;
				}

			}

		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if ((event.getCode() == KeyCode.W)  || (event.getCode() == KeyCode.UP)) {
					IsWKeyPressed = false;
				} else if ((event.getCode() == KeyCode.S)  || (event.getCode() == KeyCode.DOWN)) {
					IsSKeyPressed = false;
				} else if ((event.getCode() == KeyCode.D)  || (event.getCode() == KeyCode.RIGHT)) {
					IsDKeyPressed = false;
				} else if ((event.getCode() == KeyCode.A)  || (event.getCode() == KeyCode.LEFT)) {
					IsAKeyPressed = false;
				} else if (event.getCode() == KeyCode.M) {
					IsMKeyPressed = false;
				} else if (event.getCode() == KeyCode.R) {
					IsRKeyPressed = false;
				}

			}
		});

	}

	private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 950, 800);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.getIcons().add(new Image("Layout/RoboLogo.jpg"));
		gameStage.setTitle("RoboRally");
	}

	public void createNewGame(Stage menuStage, ROBOT chosenRobot) {
		this.menuStage = menuStage;
		this.menuStage.hide();
		createRobot(chosenRobot);
		createGameLoop();
		
		//moveToSpawn();
		gameStage.show();

	}

	private void createRobot(ROBOT chosenRobot) {
		robot = new ImageView(chosenRobot.getUrl());
		gamePane.getChildren().add(robot);
	//	moveRobotsToSpawn();
	}
	
	private void createGameLoop() {
		GameTimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				moveRobot();
			}
		};
		GameTimer.start();
	}
		/***
		 * List of all possible events 
		 */
	
	private void moveRobot() {
		if(IsWKeyPressed && !IsSKeyPressed && !IsAKeyPressed && !IsDKeyPressed) {
			if(robot.getLayoutY() > 0) {
				robot.setLayoutY(robot.getLayoutY() - 3);
				turn++;
			}
		//	System.out.printf("Turn: %s \n",turn);
		} else if(IsSKeyPressed && !IsWKeyPressed && !IsAKeyPressed && !IsDKeyPressed) {
			if(robot.getLayoutY() < 775) {
				robot.setLayoutY(robot.getLayoutY() + 3);
				turn++;
			}
		//	System.out.printf("Turn: %s \n",turn);
		}else if(IsAKeyPressed && !IsSKeyPressed && !IsWKeyPressed && !IsDKeyPressed) {
			if(robot.getLayoutX() > 0) {
				robot.setLayoutX(robot.getLayoutX() - 3);
				turn++;
			}
		//	System.out.printf("Turn: %s \n",turn);
		}else if(IsDKeyPressed && !IsSKeyPressed && !IsAKeyPressed && !IsWKeyPressed) {
			if(robot.getLayoutX() < 920 ) {
				robot.setLayoutX(robot.getLayoutX() + 3);
				turn++;
			}
		//	System.out.printf("Turn: %s \n",turn );
		}else if(IsMKeyPressed) {
			gameStage.hide();
			menuStage.show();
		}
	}
	
	
	private void endGame() {
		for (Robot robot : robots) {
			if (!robot.isFinished()) {
				System.out.println("Race finished");
			}
		}
	}

/*	private void moveRobotsToSpawn() {
		for (Robot robot : robots) {
			moveRobot(robot, map.getSpawn()[0], map.getSpawn()[1]);
		}
	}

	private void moveRobot(Robot robot, int x, int y) {
		robot.setCoordinates(x, y);
		robot.setLocation(MAP_INDENT + x * tileSize, MAP_INDENT + y * tileSize);

	}
*/
	private void nextTurn() {
		if (allRobotsIdle()) {
			endGame();
		} else {
			nextRobot();
			if (activeRobotIndex == 0) {
				turn++;
				updateTurnCount();
			}

		}
	}

	private boolean allRobotsIdle() {
		for (Robot r : robots) {
			if (!r.isFinished()) {
				return false;
			}
		}
		return true;
	}

	private void checkForEnd(Robot robot, int x, int y) {
		if (map.getTile(x, y) == Tile.END) {
			robot.finished();
			robotsFinished++;
			stop = true;
			System.out.println("Car" + activeRobotIndex + " finished the race!");
		}
	}

	private void nextRobot() {
		rotateRobot();
		while (robots[activeRobotIndex].isFinished()) {
			rotateRobot();
		}
	}

	private void rotateRobot() {
		if (activeRobotIndex < robots.length - 1) {
			activeRobotIndex++;
		} else {
			activeRobotIndex = 0;
		}
		activeRobot = robots[activeRobotIndex];
	}

	private void updateTurnCount() {
		labelTurnCount.setText(Integer.toString(turn));
	}

/*	private void checkTile(Robot robot, int x, int y) {
		if (map.isTileRideable(x, y)) {
			moveRobot(robot, x, y);
			checkForSpecialTiles(robot, x, y);
		} else {
			onRobotCrash(robot);
		}
	}
*/
	private void checkForSpecialTiles(Robot robot, int x, int y) {
		checkForEnd(robot, x, y);
	}

	private void onRobotCrash(Robot robot) {
		stop = true;
		nextTurn();

	}

}
