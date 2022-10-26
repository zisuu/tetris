package ch.finecloud;

import tetris.gui.ActionEvent;
import tetris.gui.Block;
import tetris.gui.GUI;

import java.util.Random;

public class Game {
    private final GUI gui;
    private Block block;

    public Game(GUI gui) {
        this.gui = gui;
    }

    public void start(){
        createBlock();
        updateGUI();
        while(true){
            ActionEvent event = gui.waitEvent();
            handleEvent(event);
            updateGUI();
        }
    }

    private void createBlock() {
        int randomColor = new Random().nextInt(1,8);
        this.block = new Block(4, 19, randomColor);
    }

    private void handleEvent(ActionEvent event) {
        switch (event) {
            case SHIFT_LEFT -> this.block.x--;
            case SHIFT_RIGHT -> this.block.x++;
            case SHIFT_DOWN -> this.block.y--;
            case DROP -> this.block.y = 0;
        }
    }

    private void updateGUI() {
        gui.clear();
        gui.drawBlock(this.block);
    }
}
