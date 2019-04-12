package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
	
	private Stage windowMenu;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		windowMenu = primaryStage;
		
		MainMenu menu = new MainMenu();
		primaryStage = menu.getMainStage();
		
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(e -> closeProgram());

	}

	private void closeProgram() {
		System.out.println("See ya!!"); // method which is needed for ending (closing) the program
		windowMenu.close();
	}
}