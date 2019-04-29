package main;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tmxLoader.ROBOT;
import tmxLoader.Tileset;
import tmxLoader.MapReader;

/**
 * List of all Buttons, Scenes etc. which are used;
 */

public class MainMenu {

	public Button helpButton, scoreButton, aboutButton, exitButton, backButton0, newgameButton, backButton1,
			backButton2, backButton3, backButton4, playButton;
	public Stage mainStage, gameWindow;
	public Scene mainScene, aboutScene, helpScene, scoreScene, mapSelectionScene;
	public Label labelMain, labelMapSelection;
	public VBox mainVbox;
	public TextArea helpTextArea, aboutTextArea;
	public CheckBox box1, box2;

	List<RobotPicker> robotList;
	private ROBOT chosenRobot;

	public MainMenu() {
		mainVbox = new VBox();
		mainStage = new Stage();

		mainStage.getIcons().add(new Image("Layout/RoboLogo.jpg"));
		mainStage.setTitle("RoboRally");

		Label labelMain = new Label("Welcome to the RoboRally menu!");
		Label labelMapSelection = new Label("Select the map and choose your robot");

		// Label labelAbout = new Label("This Scene is about my project.");
		// Label labelScore = new Label(" ");
		// Label labelHelp = new Label(" ");
		// TextArea aboutTextArea = new TextArea();
		// TextArea helpTextArea = new TextArea();

		MapReader mr = new MapReader();

		ChoiceBox<String> mapChoiceBox = new ChoiceBox<>();
		mapChoiceBox.getItems().addAll("Barrens", "Desert");
		mapChoiceBox.setValue("Barrens");

		ChoiceBox<String> robotChoiceBox = new ChoiceBox<>();
		robotChoiceBox.getItems().addAll("ROBOT1", "Robot2", "Robot3", "Robot4");
		robotChoiceBox.setValue("ROBOT1");

		/**
		 * setting up what will each button do (Switching the scenes);
		 */

		newgameButton = new Button("New Game");
		newgameButton.setOnAction(e -> mainStage.setScene(mapSelectionScene));

		backButton0 = new Button("Back");
		backButton0.setOnAction(e -> mainStage.setScene(mainScene));

		backButton1 = new Button("Back");
		backButton1.setOnAction(e -> mainStage.setScene(mainScene));

		backButton2 = new Button("Back");
		backButton2.setOnAction(e -> mainStage.setScene(mainScene));

		backButton3 = new Button("Back");
		backButton3.setOnAction(e -> mainStage.setScene(mainScene));

		playButton = new Button("Play");
		playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(chosenRobot != null) {
					GameView gameView = new GameView();
					gameView.createNewGame(mainStage, chosenRobot);
				} else {
					labelMapSelection.setText("Please select your robot");
				}
			}

		});

		exitButton = new Button("Exit");
		exitButton.setOnAction(e -> closeProgram());

		/*
		 * helpButton = new Button("Help"); helpButton.setOnAction(e ->
		 * mainWindow.setScene(helpScene));
		 * 
		 * scoreButton = new Button("Score"); scoreButton.setOnAction(e ->
		 * mainWindow.setScene(scoreScene));
		 * 
		 * aboutButton = new Button("About"); aboutButton.setOnAction(e ->
		 * mainWindow.setScene(aboutScene));
		 */

		/*
		 * testButton = new Button("Button"); testButton.setOnAction(e ->{
		 * labelMapSelection.setText("Coming soon");
		 * System.out.println("Desert be it");});
		 */

		/**
		 * setting up parameters for each Scene(label,buttons, stylesheet);
		 * layoutAbout,score and help are not used in the final version of the game -->
		 * prepared for the future updates
		 */

		VBox layoutMain = new VBox(50);
		layoutMain.getChildren().addAll(labelMain, newgameButton, exitButton);
		mainScene = new Scene(layoutMain, 950, 800);
		mainScene.getStylesheets().add(getClass().getResource("..\\Layout\\mainscene.css").toExternalForm());
		layoutMain.setAlignment(Pos.CENTER);

		VBox layoutMapSelection = new VBox(20);
		layoutMapSelection.getChildren().add(labelMapSelection);
		layoutMapSelection.getChildren().add(mapChoiceBox);
		layoutMapSelection.getChildren().add(robotsToChose());
		layoutMapSelection.getChildren().add(playButton);
		layoutMapSelection.getChildren().add(backButton3);
		mapSelectionScene = new Scene(layoutMapSelection, 950, 800);
		mapSelectionScene.getStylesheets().add(getClass().getResource("..\\Layout\\NewGameScene.css").toExternalForm());
		layoutMapSelection.setAlignment(Pos.CENTER);

		/*
		 * VBox layoutAbout = new VBox(20); layoutAbout.getChildren().addAll(labelAbout,
		 * aboutTextArea, backButton0); aboutScene = new Scene(layoutAbout, 950, 800);
		 * aboutScene.getStylesheets().add(getClass().getResource(
		 * "..\\Layout\\mainscene.css").toExternalForm());
		 * aboutTextArea.setText("This game was created as my graduation project");
		 * layoutAbout.setAlignment(Pos.CENTER);
		 * 
		 * VBox layoutScore = new VBox(20); layoutScore.getChildren().addAll(labelScore,
		 * backButton1); scoreScene = new Scene(layoutScore, 950, 800);
		 * scoreScene.getStylesheets().add(getClass().getResource(
		 * "..\\Layout\\mainscene.css").toExternalForm());
		 * layoutScore.setAlignment(Pos.CENTER);
		 * 
		 * VBox layoutHelp = new VBox(20); layoutHelp.getChildren().addAll(labelHelp,
		 * helpTextArea, backButton2); helpScene = new Scene(layoutHelp, 950, 800);
		 * helpScene.getStylesheets().add(getClass().getResource(
		 * "..\\Layout\\mainscene.css").toExternalForm());
		 * helpTextArea.setText("Hello there"); layoutHelp.setAlignment(Pos.CENTER);
		 */

		mainStage.setScene(mainScene);
	}

	public Stage getMainStage() {
		return mainStage;
	}

	private void closeProgram() {
		mainStage.close();
	}

	private HBox robotsToChose() {
		HBox box = new HBox();
		box.setSpacing(20);
		robotList = new ArrayList<>();
		for (ROBOT robot : ROBOT.values()) {
			RobotPicker robotToPick = new RobotPicker(robot);
			robotList.add(robotToPick);
			box.getChildren().add(robotToPick);
			robotToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for (RobotPicker robot : robotList) {
						robot.setIsCircleChosen(false);
					}
					robotToPick.setIsCircleChosen(true);
					chosenRobot = robotToPick.getRobot();
				}

			});
		}
		box.setAlignment(Pos.CENTER);
		return box;
	}

	
	String getMapName(ChoiceBox<String> mapChoiceBox) {
		String map = mapChoiceBox.getValue();
		if (map == "Desert") {
			System.out.println("Desert");
			map = "d";
		} else if (map == "Barrens") {
			System.out.println("Barrens");
			map = "b";
		}
		return map;
	}
}
