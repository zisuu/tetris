package ch.finecloud;

import tetris.gui.Block;
import java.util.Random;

public class Figure {
    private final static int COLOR = new Random().nextInt(1,8);
    private final Block[] blocks = new Block[4];

    public Figure() {
        for (int i = 0; i < blocks.length; i++) {
            this.blocks[i] = new Block(4, 19-i, COLOR);
        }
    }
    public Block[] getBlocks() {
        return this.blocks;
    }

    public void shift() {

    }

    public void rotate() {

    }
}
