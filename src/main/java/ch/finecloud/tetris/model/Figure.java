package ch.finecloud.tetris.model;

import tetris.gui.Block;

public abstract class Figure {
    protected final Block[] blocks = new Block[4];

    public Block[] getBlocks() {
        return blocks;
    }

    public void shift(int dx, int dy) {
        for (Block block : blocks) {
            block.x += dx;
            block.y += dy;
        }
    }

    public void rotate(int direction) {
        switch (direction) {
            case 1 -> {
                for (Block block : this.getBlocks()) {
                    rotateBlockRight(block);
                }
            }
            case -1 -> {
                for (Block block : this.getBlocks()) {
                    rotateBlockLeft(block);
                }
            }
        }
    }

    private void rotateBlockRight(Block block) {
        int move = 0;
        if (block.x == blocks[0].x) {
            move = blocks[0].y - block.y;
            block.x += move * -1;
        } else if (block.y == blocks[0].y) {
            move = blocks[0].x - block.x;
            block.x += move;
        } else {
            if ((block.x > blocks[0].x && block.y > blocks[0].y) || (block.x < blocks[0].x && block.y < blocks[0].y)) {
                move = (blocks[0].x - block.x) * 2;
            } else {
                block.x += (blocks[0].y - block.y) * -2;
            }
        }
        block.y += move;
    }

    private void rotateBlockLeft(Block block) {
        int move = 0;
        if (block.x == blocks[0].x) {
            move = blocks[0].y - block.y;
            block.y += move;
        } else if (block.y == blocks[0].y) {
            move = blocks[0].x - block.x;
            block.y += move * -1;
        } else {
            if ((block.x > blocks[0].x && block.y > blocks[0].y) || (block.x < blocks[0].x && block.y < blocks[0].y)) {
                move = (blocks[0].x - block.x) * 2;
            } else {
                block.y += (blocks[0].y - block.y) * 2;
            }
        }
        block.x += move;
    }
}
