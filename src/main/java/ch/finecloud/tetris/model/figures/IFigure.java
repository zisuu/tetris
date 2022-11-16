package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

/**
 * The class IFigure implements an I-shaped figure of the Tetris game.
 *
 */
public class IFigure extends Figure {

    /**
     * The color of the figure.
     */
    private final static int COLOR = 1;

    /**
     * Creates an I-shaped figure.
     *
     * @param x the x coordinate of the initial position
     * @param y the y coordinate of the initial position
     */
    public IFigure(int x, int y) {
        for (int i = 0; i < blocks.length; i++) {
            this.blocks[i] = new Block(x, y -i , COLOR);
        }
    }
}
