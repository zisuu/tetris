package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

import java.util.Random;

public class TFigure extends Figure {
    private final static int COLOR = 6;

    public TFigure(int x, int y) {
        this.blocks[0] = new Block(x+1, y , COLOR);
        this.blocks[1] = new Block(x, y , COLOR);
        this.blocks[2] = new Block(x-1, y , COLOR);
        this.blocks[3] = new Block(x, y-1 , COLOR);
    }
}
