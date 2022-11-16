package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

/**
 * The class TFigure implements a T-shaped figure of the Tetris game.
 *
 */
public class TFigure extends Figure {

    /**
     * The color of the figure.
     */
    private final static int COLOR = 6;

    /**
     * Creates a T-shaped figure.
     *
     * @param x the x coordinate of the initial position
     * @param y the y coordinate of the initial position
     */
    public TFigure(int x, int y) {
        this.blocks[0] = new Block(x, y, COLOR);
        this.blocks[1] = new Block(x-1, y, COLOR);
        this.blocks[2] = new Block(x+1, y, COLOR);
        this.blocks[3] = new Block(x, y-1, COLOR);
    }
}
