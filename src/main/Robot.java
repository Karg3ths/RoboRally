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
	private RobotType type;
	private RobotAI robot;
	private boolean finished;
	private boolean crashed;

	public Robot(String playerName, String aiName,RobotType type, RobotAI robot, Game game) {
		this.playerName = playerName;
		this.aiName = aiName;
		this.game = game;
		this.robot = robot;
		coordinates = new int[] { 0, 0 };
		finished = false;
		setSize(game.getTileSize(), game.getTileSize());
		setBackground(new java.awt.Color(0, 0, 0, 0));
	}

    /**
     * Determines which texture should the car use and paints the car.
     * Also paints the numbers representing the waiting time (in turns) after the car crashed.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setSize(game.getTileSize(), game.getTileSize());
        BufferedImage image;
        switch (type) {
            case AI:
                image = Tileset.robotAI;
                break;
            case AI2:
                image = Tileset.robotAI2;
                break;
            case AI3:
                image = Tileset.robotAI3;
                break;
            case PLAYER:
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
    /**
     * Sets the car to "crashed" and start the crash-countdown.
     */
    public void crashed() {
        crashed = true;
    }
    public void finished() {
        finished = true;
    }
    /**
     * Returns true if the car is crashed.
     * @return true if the car is crashed.
     */
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

