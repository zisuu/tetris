package ch.finecloud.tetris.model;

import tetris.gui.Block;

public class Field {

    private final int width;
    private final int height;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean detectCollision(Block[] blocks) {
        boolean collisionDetected = false;
        for (Block block : blocks) {
            if (block.x < 0 || block.x == this.width) {
                collisionDetected = true;
            } else if (block.y < 0 || block.y == this.height) {
                collisionDetected = true;
            }
        }
        return collisionDetected;
    }
}
