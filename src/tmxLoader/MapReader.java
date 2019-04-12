package tmxLoader;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import tmxLoader.Tile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MapReader {

	private Document createDocFromFile(String fileName)
			throws IOException, SAXException, ParserConfigurationException, IllegalArgumentException {
		try {
			InputStream in = getClass().getResourceAsStream("/Maps/" + fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse(in);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (Exception e) {
			System.out.println("Error while loading " + "/Maps/" + fileName);
			throw e;
		}
	}

	private int[][] getIntData(String mapFile) throws IOException, ParserConfigurationException, SAXException {
		String[] row;
		String[] dataRows = createDocFromFile(mapFile).getElementsByTagName("data").item(0).getTextContent()
				.split("\n");
		int[][] data = new int[dataRows.length - 1][dataRows[1].split(",").length];
		for (int i = 1; i < dataRows.length; i++) {
			row = dataRows[i].split(",");
			for (int a = 0; a < row.length; a++) {
				data[i - 1][a] = Integer.parseInt(row[a]);
			}
		}
		return data;
	}

	private HashMap<Integer, Tile> getTileSet(String fileName)
			throws IOException, ParserConfigurationException, SAXException {
		HashMap<Integer, Tile> tileSet = new HashMap<>();
		Document doc = createDocFromFile(fileName);
		NodeList nodeList = doc.getElementsByTagName("tile");
		String imageFileName;
		for (int i = 0; i < nodeList.getLength(); i++) {
			imageFileName = nodeList.item(i).getChildNodes().item(1).getAttributes().item(1).getNodeValue()
					.substring(3);
			if (imageFileName.equals("spawn.png")) {
				tileSet.put(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()) + 1, Tile.SPAWN);
			} else if (imageFileName.equals("end.png")) {
				tileSet.put(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()) + 1, Tile.END);
			} else if (imageFileName.equals("grass.png")) {
				tileSet.put(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()) + 1, Tile.GRASS);
			} else if (imageFileName.equals("flowergrass.png")) {
				tileSet.put(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()) + 1,
						Tile.FLOWERGRASS);
			} else if (imageFileName.equals("brickwall.png")) {
				tileSet.put(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()) + 1,
						Tile.BRICKWALL);
			} else if (imageFileName.equals("water.png")) {
				tileSet.put(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()) + 1, Tile.WATER);
			} else if (imageFileName.equals("waterwithstone.png")) {
				tileSet.put(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()) + 1,
						Tile.WATERWITHSTONE);
			} else if (imageFileName.equals("stone.png")) {
				tileSet.put(Integer.parseInt(nodeList.item(i).getAttributes().item(0).getNodeValue()) + 1, Tile.STONE);
			}
		}
		return tileSet;
	}

	public Tile[][] getMapData(String mapFileName, String tileSetFileName)
			throws IOException, ParserConfigurationException, SAXException {
		int[][] mapInt = getIntData(mapFileName);
		HashMap<Integer,Tile> tileSet = getTileSet(tileSetFileName);
		Tile[][] mapTile = new Tile[mapInt.length][mapInt[0].length];
		for (int y = 0; y < mapInt[0].length; y++) {
			for (int x = 0; x < mapInt[0].length; x++) {
				for (Integer i : tileSet.keySet()) {
					if (i == mapInt[y][x]) {
						mapTile[y][x] = tileSet.get(i);
						break;
					}
				}
			}
		}
		return mapTile;
	}

	public String[] getListOFFiles(String fileList) {
		try {
			ArrayList<String> array = new ArrayList<>();
			InputStream in = getClass().getResourceAsStream(fileList);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = reader.readLine();
			while (line != null) {
				array.add(line);
				line = reader.readLine();
			}
			String[] list = new String[array.size()];
			for (int i = 0; i < list.length; i++) {
				list[i] = array.get(i);
			}
			return list;
		} catch (IOException e) {
			System.out.println("Error while reading" + fileList);
			e.printStackTrace();
			return null;
		}
	}
}
