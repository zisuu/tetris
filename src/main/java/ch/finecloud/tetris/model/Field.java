package ch.finecloud.tetris.model;

import ch.finecloud.tetris.Tetris;
import tetris.gui.Block;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {
    private final List<Block> blocks;

    public Field() {
        blocks = new ArrayList<Block>();
    }

    public void addBlocks(Block[] blocks) {
        this.blocks.addAll(Arrays.asList(blocks));
    }

    public List<Block> getBlocks() {
        return this.blocks;
    }

    public void clear() {
        this.blocks.clear();
    }

    public boolean detectCollision(Block[] blocks) {
        boolean collisionDetected = false;
        for (Block block : blocks) {
            // check if figure is our of game field
            if (block.x < 0 || block.x >= Tetris.WIDTH) {
                collisionDetected = true;
            } else if (block.y < 0 || block.y >= Tetris.HEIGHT) {
                collisionDetected = true;
            }
            // check if new block conflicts with already existent blocks in field
            for (Block value : this.blocks) {
                if (value.x == block.x && value.y == block.y) {
                    collisionDetected = true;
                    break;
                }
            }
        }
        return collisionDetected;
    }
}
