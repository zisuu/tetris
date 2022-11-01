package ch.finecloud.tetris.model;

import tetris.gui.ActionEvent;
import tetris.gui.GUI;

public class Game {
    private final GUI gui;
    private Figure figure;
    private final int width;
    private final int height;


    public Game(int width, int height, GUI gui) {
        this.width = width;
        this.height = height;
        this.gui = gui;
    }

    public void start(){
        createFigure();
        while(true){
            ActionEvent event = gui.waitEvent();
            handleEvent(event);
            updateGUI();
        }
    }

    private void createFigure() {
        int x = (width -1) / 2;
        int y = (height -1);
        this.figure = new Figure(x, y);
        updateGUI();
    }

    private void handleEvent(ActionEvent event) {
        switch (event) {
            case ROTATE_RIGHT -> figure.rotate(1);
            case ROTATE_LEFT -> figure.rotate(-1);
            case SHIFT_LEFT -> figure.shift(-1, 0);
            case SHIFT_RIGHT -> figure.shift(+1, 0);
            case SHIFT_DOWN -> figure.shift(0, -1);
        }
    }

    private void updateGUI() {
        gui.clear();
        gui.drawBlocks(figure.getBlocks());
    }
}
