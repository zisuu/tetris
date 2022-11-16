package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

/**
 * The class OFigure implements an O-shaped figure of the Tetris game.
 *
 */
public class OFigure extends Figure {

    /**
     * The color of the figure.
     */
    private final static int COLOR = 4;


    /**
     * Creates an O-shaped figure.
     *
     * @param x the x coordinate of the initial position
     * @param y the y coordinate of the initial position
     */
    public OFigure(int x, int y) {
        this.blocks[0] = new Block(x, y, COLOR);
        this.blocks[1] = new Block(x+1, y, COLOR);
        this.blocks[2] = new Block(x, y-1, COLOR);
        this.blocks[3] = new Block(x+1, y-1, COLOR);
    }

    /**
     * Rotates the figure.
     *
     * @param direction the direction of rotation (+1 right, -1 left))
     */
    @Override
    public void rotate(int direction) {
        // do nothing because the figure doesn't change position of you rotate it
    }
}
