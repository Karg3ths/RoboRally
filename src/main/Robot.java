package main;

import main.Game;
import tmxLoader.Tileset;
import tmxLoader.RobotType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Robot extends JPanel {

	private Game game;
	private String playerName, aiName;
	private int[] coordinates;
	private RobotAI robot;
	private boolean finished;

	public Robot(String playerName, String aiName, RobotAI robot, Game game) {
		this.playerName = playerName;
		this.aiName = aiName;
		this.game = game;
		this.robot = robot;
		coordinates = new int[] { 0, 0 };
		finished = false;
		setSize(game.getTileSize(), game.getTileSize());
		setBackground(new java.awt.Color(0, 0, 0, 0));
	}
	public void setCoordinates(int x, int y) {
        coordinates[0] = x;
        coordinates[1] = y;
}
	 public void setCoordinates(int[] coordinates) {
	        if (coordinates.length != 2) {
	            throw new IllegalArgumentException("Coordinates are in the wrong format.");
	        } else {
	            this.coordinates = coordinates;
	}
}
	 public int[] getCoordinates() {
	        int[] coordinatesCopy = new int[2];
	        coordinatesCopy[0] = coordinates[0];
	        coordinatesCopy[1] = coordinates[1];
	        return coordinatesCopy;
	} 
	 public int getTileX() {
	        return coordinates[0];
	}
	 public int getTileY() {
		 return coordinates[1];
	 }
	 public RobotAI getDriver() {
	        return robot;
	    }
	 public String getPlayerName() {
		 return playerName;
}
	 public String getAiName() {
	        return aiName;
	    }

}

