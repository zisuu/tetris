package ch.finecloud.tetris;

import ch.finecloud.tetris.model.Game;
import tetris.gui.GUI;

public class Tetris {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;

    public static void main(String[] args) {
        int width, height;
        try {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            width = WIDTH;
            height = HEIGHT;
        }
        GUI gui = new GUI(width,height);
        Game game = new Game(gui);
        game.start();
    }
}