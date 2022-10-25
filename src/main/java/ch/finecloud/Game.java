package ch.finecloud;

import tetris.gui.ActionEvent;
import tetris.gui.Block;
import tetris.gui.GUI;

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
        this.block = new Block(5,19,1);
    }

    private void handleEvent(ActionEvent event) {
        if (event == ActionEvent.SHIFT_LEFT) {
            this.block.x--;
        }
    }
    private void updateGUI() {
        gui.clear();
        gui.drawBlock(this.block);
    }
}
