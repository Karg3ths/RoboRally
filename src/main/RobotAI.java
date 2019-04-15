package main;

import tmxLoader.Tile;

public interface RobotAI {

	    int[] go(int[] robotCoordinates, Tile[][] map);
	    void init(Tile[][] map);
}
