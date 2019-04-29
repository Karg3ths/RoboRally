package main;

import main.Game;
import tmxLoader.Tileset;
import tmxLoader.ROBOT;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Robot extends JPanel {

	private Game game;
	private String playerName, aiName;
	private int[] coordinates;
	private ROBOT type;
	private RobotAI robot;
	private boolean finished;
	private boolean crashed;

	public Robot(String playerName, String aiName,ROBOT type, RobotAI robot, Game game) {
		this.playerName = playerName;
		this.aiName = aiName;
		this.game = game;
		this.robot = robot;
		coordinates = new int[] { 0, 0 };
		finished = false;
		setSize(game.getTileSize(), game.getTileSize());
		setBackground(new java.awt.Color(0, 0, 0, 0));
	}
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setSize(game.getTileSize(), game.getTileSize());
        BufferedImage image;
        switch (type) {
            case ROBOT2:
                image = Tileset.robotAI;
                break;
            case ROBOT3:
                image = Tileset.robotAI2;
                break;
            case ROBOT4:
                image = Tileset.robotAI3;
                break;
            case ROBOT1:
                image = Tileset.robotPlayer;
                break;
        }
    }
    public void setCoordinates(int x, int y) {
        coordinates[0] = x;
        coordinates[1] = y;
    }
    public void setCoordinates(int[] coordinates) {
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Wrong format of coordinates");
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
   public void crashed() {
        crashed = true;
    }

    public void finished() {
        finished = true;
    }
   public boolean isCrashed() {
        return crashed;
    }

    public boolean isFinished() {
        return finished;
}
	 public RobotAI getRobot() {
	        return robot;
	    }
	 public String getPlayerName() {
		 return playerName;
}
	 public String getAiName() {
	        return aiName;
	    }

}

