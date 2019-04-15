package main;

import tmxLoader.*;
import main.Map;
import main.MainMenu;
import main.mainScene;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Game {

	private final static String TILE_SET_FILE_NAME = "RoBoRally.tsx";
	private final static int MAP_INDENT = 15;
	private Map map;
	private int turn;
	private int tileSize;
	private Robot[] robots;
	private int activeRobotIndex;
	private int robotsFinished;
	private Robot activeRobot;
	private boolean stop;
	private Scene gameScene;
	private Label labelTurnCount;
	private Button menuButton;
	

	private void initMap(String mapName) throws ParserConfigurationException, SAXException, IOException {
		map = new Map(mapName, TILE_SET_FILE_NAME, this);
		map.setLocation(MAP_INDENT, MAP_INDENT);
		map.setVisible(true);
		add(map);
		moveRobotsToStart();
		activeRobotIndex = robots.length - 1;
		stop = false;
		turn = 0;
		
		menuButton = new Button("Menu");
		menuButton.setOnAction(e -> mainWindow.setScene(mainScene));
		VBox layoutMain = new VBox(50);
		layoutMain.getChildren().addAll(labelTurnCount, menuButton);
		gameScene = new Scene(layoutMain, 950, 800);
		layoutMain.setAlignment(Pos.CENTER);

		System.out.println("map initialized");
	}

	public int getTileSize() {
		return tileSize;
	}

	private void addComponents() {
		addRobots();
		add(map);
	}

	private void addRobots() {
		for (Robot robot : robots) {
			add(robot);
		}
	}

	private void endGame() {
		for (Robot robot : robots) {
			if (!robot.isFinished()) {
				System.out.println("Race finished");
			}
		}
	}

	private void moveRobotsToStart() {
		for (Robot robot : robots) {
			moveRobot(robot, map.getSpawn()[0], map.getSpawn()[1]);
		}
	}

	private void moveRobot(Robot robot, int x, int y) {
		robot.setCoordinates(x, y);
		robot.setLocation(MAP_INDENT + x * tileSize, MAP_INDENT + y * tileSize);

	}
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
            if (!r.isFinished()){
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

/**
 *  Handle user input
 */
	 public void keyTyped(KeyEvent e) {}
	 
	
	public void keyPressed(KeyEvent e, Robot robot, int x, int y, int turn) {
		robot.setCoordinates(x, y);
		if (e.getKeyCode() == KeyEvent.VK_W) {
			robot.setLocation(MAP_INDENT + x, MAP_INDENT + (y + 1));
			updateTurnCount();
			nextTurn();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			robot.setLocation(MAP_INDENT + x, MAP_INDENT + (y - 1));
			updateTurnCount();
			nextTurn();
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			robot.setLocation(MAP_INDENT + (x - 1), MAP_INDENT + y);
			updateTurnCount();
			nextTurn();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			robot.setLocation(MAP_INDENT + (x + 1), MAP_INDENT + y);
			updateTurnCount();
			nextTurn();
		}

	}
	    public void keyReleased(KeyEvent e) {}
	     
	    private void updateTurnCount() {
	        labelTurnCount.setText(Integer.toString(turn));
	}
	    private void checkTile(Robot robot, int x, int y) {
	        if (map.isTileRideable(x, y)) {
	            moveRobot(robot, x, y);
	            checkForSpecialTiles(robot, x, y);
	        } else {
	            onRobotCrash(robot);
	        }
	        private void checkForSpecialTiles(Robot robot, int x, int y) {
	        	checkForEnd(robot, x, y);
	        }

	    
	    
	    private void onRobotCrash(Robot robot) {
	        stop = true;
	        nextTurn();


}