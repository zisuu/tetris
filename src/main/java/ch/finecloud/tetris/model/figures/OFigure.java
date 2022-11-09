package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

import java.util.Random;

public class OFigure extends Figure {
    private final static int COLOR = 4;

    public OFigure(int x, int y) {
        this.blocks[0] = new Block(x, y , COLOR);
        this.blocks[1] = new Block(x-1, y , COLOR);
        this.blocks[2] = new Block(x, y-1 , COLOR);
        this.blocks[3] = new Block(x-1, y-1 , COLOR);
    }

    @Override
    public void rotate(int direction) {
        // do nothing because the figure doesn't change position of you rotate it
    }
}
