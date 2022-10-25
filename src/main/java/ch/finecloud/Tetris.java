package ch.finecloud;

import tetris.gui.Block;
import tetris.gui.GUI;

public class Tetris {
    public static void main(String[] args) {
        GUI gui = new GUI(18,20);
        Game game = new Game(gui);
        game.start();
    }
}