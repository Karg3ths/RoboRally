package tmxLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Loads all images which are needed for the game
 */

public class Tileset {
	public static BufferedImage spawntile, endtile, grasstile, flowergrasstile, watertile, waterwithstonetile,
			bricktile, stonetile, sandtile, flowersandtile;
	public static BufferedImage robotPlayer, robotAI, robotAI2, robotAI3;

	public static void load() {

		spawntile = loadImage("spawn.png");
		endtile = loadImage("end.png");
		grasstile = loadImage("grass.png");
		flowergrasstile = loadImage("flowergrass.png");
		watertile = loadImage("water.png");
		waterwithstonetile = loadImage("waterwithstone.png");
		bricktile = loadImage("brickwall.png");
		stonetile = loadImage("stone.png");
		sandtile = loadImage("sand.png");
		flowersandtile = loadImage("flowersand.png");
		robotPlayer = loadImage("robotPlayer.png");
        robotAI = loadImage("robotAI.png");
        robotAI2 = loadImage("robotAI2.png");
        robotAI3 = loadImage("robotAI3.png");
	}

	/**
	 * Creates BufferedImage from the image file.
	 */

	private static BufferedImage loadImage(String fileName) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(Tileset.class.getResourceAsStream("/Tiles/" + fileName));
		} catch (IOException e) {
			System.out.println("Error while loading" + fileName);
			e.printStackTrace();
		}
		return image;
	}
}
