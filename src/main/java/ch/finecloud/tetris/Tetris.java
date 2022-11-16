package ch.finecloud.tetris;

import ch.finecloud.tetris.model.Game;
import tetris.gui.GUI;

/**
 * The class Tetris is the main class to start a Tetris game.
 *
 */
public class Tetris {

    /**
     * The width of the field.
     */
    public static final int WIDTH = 10;

    /**
     * The height of the field.
     */
    public static final int HEIGHT = 20;

    /**
     * Creates a Tetris game with a graphical user interface and starts it.
     */
    public static void main(String[] args) {
        int width, height;
        try {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            width = WIDTH;
            height = HEIGHT;
        }
        GUI gui = new GUI(width,height, 6);
        Game game = new Game(gui);
        game.start();
    }
}