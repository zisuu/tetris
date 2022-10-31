package ch.finecloud;

import tetris.gui.ActionEvent;
import tetris.gui.GUI;

import static tetris.gui.ActionEvent.ROTATE_LEFT;
import static tetris.gui.ActionEvent.ROTATE_RIGHT;

public class Game {
    private final GUI gui;
    private Figure figure;

    public Game(GUI gui) {
        this.gui = gui;
    }

    public void start(){
        createFigure();
        updateGUI();
        while(true){
            ActionEvent event = gui.waitEvent();
            handleEvent(event);
            updateGUI();
        }
    }

    private void createFigure() {
        this.figure = new Figure();
    }

    private void handleEvent(ActionEvent event) {
        if (event.equals(ROTATE_LEFT) || event.equals(ROTATE_RIGHT)) {
            figure.rotate(event);
        } else {
            figure.shift(event);
        }
    }

    private void updateGUI() {
        gui.clear();
        gui.drawBlocks(figure.getBlocks());
    }
}
