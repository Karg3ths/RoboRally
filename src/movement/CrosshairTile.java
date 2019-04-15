package movement;

import main.Game;
import tmxLoader.Tileset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Represents one tile of the crosshair used by human players to control their cars.
 */
public class CrosshairTile extends JPanel implements MouseListener {

    /**
     * The game of which is the crosshair component.
     */
    private Game game;
    /**
     * The index of the crosshair tile representing which tile of the crosshair it is.
     */
    private int[] index;
    /**
     * The coordinate of the crosshair tile.
     */
    private int x, y;
    private boolean mouseOver;
    private boolean isNextAiMove;

    public CrosshairTile(int[] index, Game game) {
        this.game = game;
        this.index = index;
        x = 0;
        y = 0;
        isNextAiMove = false;
        setSize(game.getTileSize(), game.getTileSize());
        setBackground(new Color(0, 0, 0, 0));
        addMouseListener(this);
    }

    /**
     * Determines which texture this tile of crosshair should use
     * depending on wheter it should be highlighted as next AI move and paints it.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setSize(game.getTileSize(), game.getTileSize());
        BufferedImage image;
        if (game.humanOnTurn()) {           
              image = Tileset.crosshair;
        } else {
                image = Tileset.crosshair;
            }
        }
        g.drawImage(image.getScaledInstance(game.getTileSize(), game.getTileSize(), Image.SCALE_SMOOTH), 0, 0, null);
    }

    /**
     * Returns the index of this crosshair tile.
     * @return the index of this crosshair tile.
     */
    public int[] getIndex() {
        return index;
    }

    /**
     * Sets the coordinates of this crosshair tile.
     * @param x the value to which is the X coordinate to be set.
     * @param y the value to which is the Y coordinate to be set.
     */
    public void setTileXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X coordinate of this crosshair tile.
     * @return the X coordinate of this crosshair tile.
     */
    public int getTileX() {
        return x;
    }

    /**
     * Returns the Y coordinate of this crosshair tile.
     * @return the Y coordinate of this crosshair tile.
     */
    public int getTileY() {
        return y;
    }

    /**
     * Calls the game.onCHClick() method when the crosshair tile is clicked by the user
     * and passes the index of the crosshair tile to it.
     * @see Game#onCHClick(int[])
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        game.onCHClick(index);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
    public void setIsNextAiMove(boolean b) {
        isNextAiMove = b;
}
}
