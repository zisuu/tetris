package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

/**
 * The class LFigure implements an L-shaped figure of the Tetris game.
 *
 */
public class LFigure extends Figure {

    /**
     * The color of the figure.
     */
    private final static int COLOR = 3;

    /**
     * Creates an L-shaped figure.
     *
     * @param x the x coordinate of the initial position
     * @param y the y coordinate of the initial position
     */
    public LFigure(int x, int y) {
        this.blocks[0] = new Block(x, y, COLOR);
        this.blocks[1] = new Block(x-1, y, COLOR);
        this.blocks[2] = new Block(x+1, y, COLOR);
        this.blocks[3] = new Block(x-1, y-1, COLOR);
    }
}
