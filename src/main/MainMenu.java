package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * List of all Buttons, Scenes etc. which are used;
 */

public class MainMenu {

	public Button helpButton, scoreButton, aboutButton, exitButton, backButton0, newgameButton, backButton1, backButton2, backButton3, backButton4,
				  mapBarrens, mapXXXXXD;
	public Stage mainWindow;
	public Scene mainScene, aboutScene, helpScene, scoreScene, mapSelectionScene;
	public Label labelMain, labelMapSelection;
	public VBox mainVbox;

	public MainMenu() {
		mainVbox = new VBox();
		mainWindow = new Stage();
		
		mainWindow.getIcons().add(new Image("Layout/RoboLogo.jpg"));
		mainWindow.setTitle("RoboRally");
		
		Label labelMain = new Label("Welcome to the RoboRally menu!");
		Label labelAbout = new Label("This Scene is about my project.");
		Label labelScore = new Label(" ");
		Label labelHelp = new Label(" ");
		Label labelMapSelection = new Label("Select the map");
	/**
	 * setting up what will each button do (Switching the scenes);	
	 */
		newgameButton = new Button("New Game");
		newgameButton.setOnAction(e -> mainWindow.setScene(mapSelectionScene));

		helpButton = new Button("Help");
		helpButton.setOnAction(e -> mainWindow.setScene(helpScene));

	/*	scoreButton = new Button("Score");
		scoreButton.setOnAction(e -> mainWindow.setScene(scoreScene));
    */
		aboutButton = new Button("About");
		aboutButton.setOnAction(e -> mainWindow.setScene(aboutScene));

		backButton0 = new Button("Back");
		backButton0.setOnAction(e -> mainWindow.setScene(mainScene));
		
		backButton1 = new Button("Back");
		backButton1.setOnAction(e -> mainWindow.setScene(mainScene));
		
		backButton2 = new Button("Back");
		backButton2.setOnAction(e -> mainWindow.setScene(mainScene));
		
		backButton3 = new Button("Back");
		backButton3.setOnAction(e -> mainWindow.setScene(mainScene));
		
		mapBarrens = new Button("Barrens");
		mapBarrens.setOnAction(e -> labelMapSelection.setText("Coming soon"));
		
		mapXXXXXD = new Button("Coming Soon");
		mapXXXXXD.setOnAction(e -> labelMapSelection.setText("Coming soon"));

		exitButton = new Button("Exit");
		exitButton.setOnAction(e -> closeProgram());

/**
 * setting up parameters for each Scene(label,buttons, stylesheet);
 */
		
		VBox layoutMain = new VBox(50);
		layoutMain.getChildren().addAll(labelMain, newgameButton, helpButton, aboutButton, exitButton);
		mainScene = new Scene(layoutMain, 950, 800);
		mainScene.getStylesheets().add(getClass().getResource("..\\Layout\\mainscene.css").toExternalForm());
		layoutMain.setAlignment(Pos.CENTER);

		VBox layoutAbout = new VBox(20);
		layoutAbout.getChildren().addAll(labelAbout, backButton0);
		aboutScene = new Scene(layoutAbout, 950, 800);
		aboutScene.getStylesheets().add(getClass().getResource("..\\Layout\\mainscene.css").toExternalForm());
		layoutAbout.setAlignment(Pos.CENTER);
		
		VBox layoutScore = new VBox(20);
		layoutScore.getChildren().addAll(labelScore, backButton1);
		scoreScene = new Scene(layoutScore, 950, 800);
		scoreScene.getStylesheets().add(getClass().getResource("..\\Layout\\mainscene.css").toExternalForm());
		layoutScore.setAlignment(Pos.CENTER);
		
		VBox layoutHelp = new VBox(20);
		layoutHelp.getChildren().addAll(labelHelp, backButton2);
		helpScene = new Scene(layoutHelp, 950, 800);
		helpScene.getStylesheets().add(getClass().getResource("..\\Layout\\mainscene.css").toExternalForm());
		layoutHelp.setAlignment(Pos.CENTER);
		
		VBox layoutMapSelection = new VBox(20);
		layoutMapSelection.getChildren().addAll(labelMapSelection, mapBarrens, mapXXXXXD, backButton3);
		mapSelectionScene = new Scene(layoutMapSelection, 950, 800);
		mapSelectionScene.getStylesheets().add(getClass().getResource("..\\Layout\\mainscene.css").toExternalForm());
		layoutMapSelection.setAlignment(Pos.CENTER);

		mainWindow.setScene(mainScene);
	}

	public Stage getMainStage() {
		return mainWindow;
	}

	private void closeProgram() {
		mainWindow.close();
	}
}

