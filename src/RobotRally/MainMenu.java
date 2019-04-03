package RobotRally;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenu {

	public Button helpButton, scoreButton, aboutButton, exitButton, backButton, newgameButton, backButton2, backButton3, backButton4;
	public Stage mainWindow;
	public Scene mainScene, aboutScene, helpScene, scoreScene;
	public Label labelMain;

	public MainMenu() {
	//	mainVbox = new VBox();
		mainWindow = new Stage();
		Image background = new Image("Layout/lodicka.png");
		ImageView picture = new ImageView();
		picture.setImage(background);
		
		mainWindow.getIcons().add(new Image("Layout/lodicka.png"));
		mainWindow.setTitle("RoboRally");
		
		Label labelMain = new Label("Welcome to the RoboRally menu!");
		Label labelAbout = new Label("This Scene is about my project.");
		Label labelScore = new Label(" ");
		Label labelHelp = new Label(" ");
		
		newgameButton = new Button("New Game");
		newgameButton.setOnAction(e -> labelMain.setText("Well, it seems like there is no game at all. It almost seems like the lazy creator has done nothing."));

		helpButton = new Button("Help");
		helpButton.setOnAction(e -> mainWindow.setScene(helpScene));

		scoreButton = new Button("Score");
		scoreButton.setOnAction(e -> mainWindow.setScene(scoreScene));

		aboutButton = new Button("About");
		aboutButton.setOnAction(e -> mainWindow.setScene(aboutScene));

		backButton = new Button("Back");
		backButton.setOnAction(e -> mainWindow.setScene(mainScene));
		
		backButton2 = new Button("Back");
		backButton2.setOnAction(e -> mainWindow.setScene(mainScene));
		
		backButton3 = new Button("Back");
		backButton3.setOnAction(e -> mainWindow.setScene(mainScene));
		
		backButton4 = new Button("Back");
		backButton4.setOnAction(e -> mainWindow.setScene(mainScene));

		exitButton = new Button("Exit");
		exitButton.setOnAction(e -> closeProgram());

		VBox layoutMain = new VBox(50);
		layoutMain.getChildren().addAll(newgameButton, helpButton, scoreButton, aboutButton, exitButton);
		mainScene = new Scene(layoutMain, 950, 800);
		mainScene.getStylesheets().add(getClass().getResource("..\\Layout\\mainscene.css").toExternalForm());
		layoutMain.setAlignment(Pos.CENTER);

		VBox layoutAbout = new VBox(20);
		layoutAbout.getChildren().addAll(labelAbout, backButton);
		aboutScene = new Scene(layoutAbout, 950, 800);
		layoutAbout.setAlignment(Pos.CENTER);
		
		VBox layoutScore = new VBox(20);
		layoutScore.getChildren().addAll(labelScore, backButton2);
		scoreScene = new Scene(layoutScore, 950, 800);
		layoutScore.setAlignment(Pos.CENTER);
		
		VBox layoutHelp = new VBox(20);
		layoutHelp.getChildren().addAll(labelHelp, backButton3);
		helpScene = new Scene(layoutHelp, 950, 800);
		layoutHelp.setAlignment(Pos.CENTER);

		mainWindow.setScene(mainScene);
	}

	public Stage getMainStage() {
		return mainWindow;
	}

	private void closeProgram() {
		System.out.println("See ya!!");
		mainWindow.close();
	}
}
