package main;

import main.Game;
import tmxLoader.Tile;

import org.xml.sax.SAXException;
import tmxLoader.MapReader;
import tmxLoader.Tileset;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

/**
 * Represents the tiled map in the game.
 */
public class Map extends JPanel {

    /**
     * The game of which the map is component.
     */
    private Game game;
    /**
     * The size of the map.
     */
    private int tileWidth, tileHeight;
    /**
     * The coordinates of the start.
     */
    private int[] start;
    /**
     * The array containing the tile types of all tiles.
     */
    private Tile[][] mapTile;

    /**
     * The Map class constructor. Initializes attributes of the map.
     * Uses the DataReader class to get the required data from the map file.
     * @param mapFileName the name of the map file from which the data for initialization of this map are to be gathered.
     * @param tileSetFileName the name of the tile-set file which is to be used to 'translate'
     *                        the data in numbers from the map file to the enum Tile format.
     * @param game the instance of Game to which this map is going to be added.
     * @throws StartNotFoundException thrown if there is no start on the map or there is more than one.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @see DataReader#getMapData(String, String)
     */
    public Map(String mapFileName, String tileSetFileName, Game game) throws ParserConfigurationException, SAXException, IOException {
        this.game = game;
        MapReader mr = new MapReader();
        mapTile = mr.getMapData(mapFileName, tileSetFileName);
        tileWidth = mapTile[0].length;
        tileHeight = mapTile.length;
        setSize(tileWidth * game.getTileSize(), tileHeight * game.getTileSize());
        setBackground(Color.BLACK);
        findStart();
    }

    /**
     * Finds the start on the map and saves its coordinates.
     * @throws StartNotFoundException thrown if there is no start on the map or there is more than one.
     */
    private void findStart() {
        start = new int[2];
        boolean startFound = false;
        for (int x = 0; x < tileWidth; x++) {
            for (int y = 0; y < tileHeight; y++) {
                if (getTile(x, y) == Tile.SPAWN) {
                    if (!startFound) {
                        start[0] = x;
                        start[1] = y;
                        startFound = true;
                    } 
                }
            }
        }
        if (!startFound) {
            System.out.println("No start found on the map");
        }
    }

    /**
     * Paints each tile of the map with the corresponding texture.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tileSize = game.getTileSize();
        setSize(tileWidth * tileSize, tileHeight * tileSize);
        for (int y = 0; y < mapTile.length; y++) {
            for (int x = 0; x < mapTile[0].length; x++) {
                switch(mapTile[y][x]) {
                    case SPAWN:
                        g.drawImage(Tileset.spawntile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case END:
                        g.drawImage(Tileset.endtile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case BRICKWALL:
                        g.drawImage(Tileset.bricktile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case STONE:
                        g.drawImage(Tileset.stonetile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case GRASS:
                        g.drawImage(Tileset.grasstile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case WATER:
                        g.drawImage(Tileset.watertile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case FLOWERGRASS:
                        g.drawImage(Tileset.flowergrasstile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case SAND:
                        g.drawImage(Tileset.sandtile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case FLOWERSAND:
                        g.drawImage(Tileset.flowersandtile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                    case WATERWITHSTONE:
                        g.drawImage(Tileset.waterwithstonetile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize, y * tileSize, null);
                        break;
                }
            }
        }
    }

    /**
     * Returns the type of the tile with given coordinates.
     * @param x the X coordinate of the tile which is to be examined for its type.
     * @param y the Y coordinate of the tile which is to be examined for its type.
     * @return the type of the tile given by the coordinates.
     */
    public Tile getTile(int x, int y) {
        try {
            return mapTile[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

    }

    /**
     * Returns the type of the tile with given coordinates.
     * @param coordinates the coordinates of the tile which is to be examined for its type.
     * @return the type of the tile given by the coordinates.
     */
    public Tile getTile(int[] coordinates) {
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Method getTile only accepts two ints or an int array with the length of 2 as argument.");
        } else {
            return mapTile[coordinates[1]][coordinates[0]];
        }
    }

    /**
     * Returns true if the tile with given coordinates is rideable (anything but WALL) and is not outside the map.
     * @param x the X coordinate of the tile which is to be examined for its rideability.
     * @param y the Y coordinate of the tile which is to be examined for its rideability.
     * @return true if the tile with given coordinates id rideable.
     */
    public boolean isTileRideable(int x, int y) {
        return (getTile(x, y) != Tile.BRICKWALL) && (getTile(x, y) != null);
    }

    /**
     * Returns the tileWidth of the map in tiles.
     * @return the tileWidth of the map in tiles.
     */
    public int getWidthInTiles() {
        return tileWidth;
    }

    /**
     * Returns the tileHeight of the map in tiles.
     * @return the tileHeight of the map in tiles.
     */
    public int getHeightInTiles() {
        return tileHeight;
    }

    /**
     * Returns a deep copy of the 2d Tile array representing the map.
     * @return a deep copy of the 2d Tile array representing the map.
     */
    public Tile[][] getMapCopy() {
        Tile[][] mapCopy = new Tile[mapTile[0].length][mapTile.length];
        for (int x = 0; x < mapTile[0].length; x++) {
            for (int y = 0; y < mapTile.length; y++) {
                mapCopy[x][y] = mapTile[y][x];
            }
        }
        return mapCopy;
    }

    /**
     * Returns the coordinates of the start.
     * @return the coordinates of the start.
     */
    public int[] getStart() {
        return start;
    }
}
