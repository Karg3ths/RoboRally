package main;

import main.GameSettings;
import org.xml.sax.SAXException;
import tmxLoader.MapReader;
import tmxLoader.Tile;
import tmxLoader.Tileset;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

public class Map extends JPanel {

	private GameSettings game;
	private int tileWidth, tileHeight;
	private int[] spawn;
	private Tile[][] mapTile;

	public Map(String mapFileName, String tileSetFileName, GameSettings gameSettings)
			throws ParserConfigurationException, SAXException, IOException {
		this.game = gameSettings;
		MapReader mr = new MapReader();
		mapTile = mr.getMapData(mapFileName, tileSetFileName);
		tileWidth = mapTile[0].length;
		tileHeight = mapTile.length;
		setSize(tileWidth * gameSettings.getTileSize(), tileHeight * getTileSize());
		setBackground(Color.GRAY);
		findSpawn();
	}

	private void findSpawn() {
		spawn = new int[2];
		boolean spawnFound = false;
		for (int x = 0; x < tileWidth; x++) {
			for (int y = 0; y < tileHeight; y++) {
				if (getTile(x, y) == Tile.SPAWN) {
					if (!spawnFound) {
						spawn[0] = x;
						spawn[1] = y;
						spawnFound = true;
					}
				}
			}
		}
		if (!spawnFound) {
			System.out.println("Spawn not found");
		}
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		int tileSize = game.getTileSize();
		setSize(tileWidth * tileSize, tileHeight * tileSize);
		for (int y = 0; y < mapTile.length; y++) {
			for (int x = 0; x < mapTile[0].length; x++) {
				switch (mapTile[y][x]) {
				case SPAWN:
					g.drawImage(Tileset.spawntile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH),
							x * tileSize, y * tileSize, null);
					break;
				case GRASS:
					g.drawImage(Tileset.grasstile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH),
							x * tileSize, y * tileSize, null);
					break;
				case FLOWERGRASS:
					g.drawImage(Tileset.flowergrasstile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH),
							x * tileSize, y * tileSize, null);
					break;
				case END:
					g.drawImage(Tileset.endtile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH), x * tileSize,
							y * tileSize, null);
					break;
				case WATER:
					g.drawImage(Tileset.watertile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH),
							x * tileSize, y * tileSize, null);
					break;
				case WATERWITHSTONE:
					g.drawImage(Tileset.waterwithstonetile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH),
							x * tileSize, y * tileSize, null);
					break;
				case BRICKWALL:
					g.drawImage(Tileset.bricktile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH),
							x * tileSize, y * tileSize, null);
					break;
				case STONE:
					g.drawImage(Tileset.stonetile.getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH),
							x * tileSize, y * tileSize, null);
					break;
				}
			}
		}
	}

	public Tile getTile(int x, int y) {
		try {
			return mapTile[y][x];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public Tile getTile(int[] coordinates) {
		if (coordinates.length != 2) {
			throw new IllegalArgumentException("Not supported length of the array.");
		} else {
			return mapTile[coordinates[1]][coordinates[0]];
		}
	}

	public boolean istileAccessable(int x, int y) {
		return (getTile(x, y) != Tile.BRICKWALL) && (getTile(x, y) != null);
	}

	public int getWidthInTiles() {
		return tileWidth;
	}

	public int getHeightInTiles() {
		return tileHeight;
	}

	public Tile[][] getMapCopy() {
		Tile[][] mapCopy = new Tile[mapTile[0].length][mapTile.length];
		for (int x = 0; x < mapTile[0].length; x++) {
			for (int y = 0; y < mapTile.length; y++) {
				mapCopy[x][y] = mapTile[y][x];
			}
		}
		return mapCopy;
	}

	public int[] getSpawn() {
		return spawn;
	}
}
