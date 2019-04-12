package main;

import javafx.stage.Stage;

public class CloseProgram {
		private Stage mainWindow;
	
		public CloseProgram() {
			mainWindow = new Stage();
			mainWindow.close();
		}
		public Stage getCloseProgram() {
			return mainWindow;
		}
}