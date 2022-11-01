package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

import java.util.Random;

public class LFigure extends Figure {
    private final static int COLOR = new Random().nextInt(1,8);

    public LFigure(int x, int y) {
        this.blocks[0] = new Block(x, y , COLOR);
        this.blocks[1] = new Block(x, y-1 , COLOR);
        this.blocks[2] = new Block(x, y-2 , COLOR);
        this.blocks[3] = new Block(x+1, y-2 , COLOR);
    }
}
