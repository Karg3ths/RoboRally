package main;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import tmxLoader.ROBOT;

public class RobotPicker extends VBox {
	
	private ImageView circleImage;
	private ImageView robotImage;
	
	private String circleNotChosen = "/Layout/emptyCircle.png ";
	private String circleChosen = "/Layout/chosenCircle.png ";
	
	private ROBOT robot;

	private boolean isCircleChosen;

	
	public RobotPicker(ROBOT robot) {
		circleImage = new ImageView(circleNotChosen);
		robotImage = new ImageView(robot.getUrl());
		this.robot = robot;
		isCircleChosen = false;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.getChildren().add(circleImage);
		this.getChildren().add(robotImage);
	}
	
	public ROBOT getRobot() {
		return robot;
	}
	
	public boolean getIsCircleChosen() {
		return isCircleChosen;
	}
	
	public void setIsCircleChosen(boolean isCircleChosen) {
		this.isCircleChosen = isCircleChosen;
		String imageToSet = this.isCircleChosen ? circleChosen : circleNotChosen;
		circleImage.setImage(new Image(imageToSet));		
	}
}
