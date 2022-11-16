package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

/**
 * The class ZFigure implements a Z-shaped figure of the Tetris game.
 *
 */
public class ZFigure extends Figure {

    /**
     * The color of the figure.
     */
    private final static int COLOR = 7;

    /**
     * Creates a Z-shaped figure.
     *
     * @param x the x coordinate of the initial position
     * @param y the y coordinate of the initial position
     */
    public ZFigure(int x, int y) {
        this.blocks[0] = new Block(x, y, COLOR);
        this.blocks[1] = new Block(x-1, y, COLOR);
        this.blocks[2] = new Block(x, y-1, COLOR);
        this.blocks[3] = new Block(x+1, y-1, COLOR);
    }
}
