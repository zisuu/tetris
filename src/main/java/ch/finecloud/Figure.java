package ch.finecloud;

import tetris.gui.ActionEvent;
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

    public void shift(ActionEvent event) {
        for (Block block : blocks) {
            switch (event) {
                case SHIFT_LEFT -> block.x--;
                case SHIFT_RIGHT -> block.x++;
                case SHIFT_DOWN -> block.y--;
//                case DROP -> block.y = 0; doesn't work!
                //case ROTATE_RIGHT -> rotate(event);
            }
        }
    }

    /**
     *  90∘ rotation counterclockwise (or 270∘ clockwise): (x,y)→(−y,x)
     * 180∘ rotation counterclockwise (or 180∘ clockwise): (x,y)→(−x,−y)
     * 270∘ rotation counterclockwise (or 90∘ clockwise): (x,y)→(y,−x
     * @param event
     */
    public void rotate(ActionEvent event) {
        //Block block = blocks[i];
        int temp = 0;
        System.out.println(event);
        for (int i = 0; i < blocks.length; i++) {
            temp = blocks[i].x;
            System.out.println("block"+ i + " posx: " + blocks[i].x + " posy: " + blocks[i].y);
            temp = blocks[i].y;
            blocks[i].y = blocks[i].x;
            blocks[i].x = temp;
            System.out.println("block"+ i + " posx: " + blocks[i].x + " posy: " + blocks[i].y);
        }



//        case 1
//                    blocks[i].y = blocks[i].x;
//                    blocks[i].x += i;
//        case 2
//                blocks[i].x = blocks[i].y;
//                blocks[i].y = temp;
//            }
//        }
    }
}
