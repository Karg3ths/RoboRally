package main;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class GameSettings extends JPanel implements MouseListener {
	private final static int TURN_MAX = 100;
	private final static int MAP_INDENT =16;
	private final static String TILE_SET_FILE_NAME = "RoboRallyTileSet.tsx";
	
	private int tileSize;
	
	private JPanel cards;
	
	private Map map;
	private boolean stop;
	private int turn;
	
	

private void init() {
    setBackground(Color.darkGray);
    setLayout(null);
    setFocusable(true);
    requestFocusInWindow();
    addMouseListener(this);
}

private void initMap(String mapName) throws ParserConfigurationException, SAXException, IOException {
	map = new Map(mapName, TILE_SET_FILE_NAME, this);
	map.setLocation(MAP_INDENT, MAP_INDENT);
	map.setVisible(true);
	add(map);
	
	System.out.println("map has started");
}

private void addComponents() {
	add(map);
}
/*private void addRobots() {
    for (Robot robot : robots) {
        add(robot);
    }
}
*/
private void checkTile(Robot robot, int x, int y) {
    if (map.isTileRideable(x, y)) {
        moveCar(car, x, y);
      //  checkForSpecialTiles(car, x, y);
    } else {
        onCarCrash(car);
    }
}
