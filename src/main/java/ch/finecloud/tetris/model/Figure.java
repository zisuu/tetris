package ch.finecloud.tetris.model;

import tetris.gui.Block;
import java.util.Random;

public class Figure {
    private final static int COLOR = new Random().nextInt(1,8);
    private final Block[] blocks = new Block[4];

    public Figure(int x, int y) {
        for (int i = 0; i < blocks.length; i++) {
            this.blocks[i] = new Block(x, y -i , COLOR);
        }
    }

    public Block[] getBlocks() {
        return this.blocks;
    }

    public void shift(int dx, int dy) {
        for (Block block : blocks) {
            block.x += dx;
            block.y += dy;
        }
    }

    /**
     *  90∘ rotation counterclockwise (or 270∘ clockwise): (x,y)→(−y,x)
     * 180∘ rotation counterclockwise (or 180∘ clockwise): (x,y)→(−x,−y)
     * 270∘ rotation counterclockwise (or 90∘ clockwise): (x,y)→(y,−x)
     * b1'(x) = b0(x) - b1(x) -> 3 - 3 = 0 change -> b0y
     * b1'(y) = b0(y) - b1(y) -> 0 - 1 = -1 change -> b0x -1
     * b2'(x) = b0(x) - b2(x) -> 3 - 3 = 0 change -> b0y
     * b2'(y) = b0(y) - b2(y) -> 0 - 2 = -2 change -> b0x -2
     * b3'(x) = b0(x) - b3(x) -> 3 - 4 = -1 change -> b0y -1
     * b3'(y) = b0(y) - b3(y) -> 0 - 2 = -2 change -> b0x -2
     * @param direction
     */
    public void rotate(int direction) {
        System.out.println("b1x=" + blocks[1].x);
//        blocks[1].x = blocks[0].x;
//        System.out.println("b1x'=" + blocks[1].x);
        System.out.println("b1y=" + blocks[1].y);
        blocks[1].y = blocks[0].x -1;
        System.out.println("b1y'=" + blocks[1].y);
//        blocks[2].x = blocks[2].y;
//        blocks[2].y = blocks[0].y;
//        blocks[3].x = blocks[3].y;
//        blocks[3].y = blocks[0].y;
    }
}
