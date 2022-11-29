package ch.finecloud.tetris.model;

import ch.finecloud.tetris.Tetris;
import tetris.gui.Block;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Field {

    private final List<Block> blocks;

    public Field() {
        blocks = new ArrayList<>();
    }

    public void addBlocks(Block[] blocks) {
        this.blocks.addAll(List.of(blocks));
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
            // check if figure is out of game field
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

    /**
     * Removes the full rows from the field.
     *
     * @return the number of removed rows
     */
    public int removeFullRows() {
        int numberOfRemovedRows = 0;
        for (int y = Tetris.HEIGHT -1; y >= 0; y--) {
            while (isRowFull(y)) {
                removeRow(y);
                numberOfRemovedRows++;
            }
        }
//        for (int y = 0; y < Tetris.HEIGHT-1; y++) {
//            while (isRowFull(y)) {
//                removeRow(y);
//                numberOfRemovedRows++;
//            }
//        }
        return numberOfRemovedRows;
    }

    /**
     * Checks if a row is full of blocks.
     *
     * @param y the y-coordinate of the row
     * @return true if the row is full, false otherwise
     */
    private boolean isRowFull(int y) {
//        int numBlocks  = 0;
//        for (Block block:blocks) {
//            if (block.y == y) {
//                numBlocks++;
//            }
//        }
//        return numBlocks == Tetris.WIDTH;

        Stream<Block> blockStream;
        blockStream = blocks.stream().filter(block -> block.y == y);
        return blockStream.count() == Tetris.WIDTH;
    }

    /**
     * Removes the blocks of a row and shifts the blocks of the upper rows down.
     *
     * @param y the y-coordinate of the row
     */
    private void removeRow(int y) {

        blocks.removeIf(block -> block.y == y);

//        while (iterator.hasNext()) {
//            Block block = iterator.next();
//            if (block.y == y) {
//                iterator.remove();
//            }
//        }

        for (Block block:blocks) {
             if (block.y > y) {
                block.y--;
            }
        }

//        blocks.removeIf(block -> block.y == y);
//        for (Block block:blocks) {
//            if (block.y > y) {
//                block.y = block.y-1;
//            }
//        }
    }
}
