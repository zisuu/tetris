package ch.finecloud.tetris.model.figures;

import ch.finecloud.tetris.model.Figure;
import tetris.gui.Block;

import java.util.Random;

public class IFigure extends Figure {
//    private final static int COLOR = new Random().nextInt(1,8);
    private final static int COLOR = 1;

    public IFigure(int x, int y) {
        for (int i = 0; i < blocks.length; i++) {
            this.blocks[i] = new Block(x, y -i , COLOR);
        }
    }
}
