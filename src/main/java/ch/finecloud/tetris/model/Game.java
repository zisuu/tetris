package ch.finecloud.tetris.model;

import ch.finecloud.tetris.model.figures.*;
import tetris.gui.ActionEvent;
import tetris.gui.ActionHandler;
import tetris.gui.GUI;

import java.util.Random;

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
        FigureController figureController = new FigureController(); //new
        gui.setActionHandler(figureController); //new
        updateGUI();
//        while(true){
//            ActionEvent event = gui.waitEvent();
//            handleEvent(event);
//        }
    }

    private void createFigure() {
        int x = (width -1) / 2;
        int y = (height -1);
        int figureID = new Random().nextInt(1,8);
        switch (figureID) {
            case 1 -> this.figure = new IFigure(x, y);
            case 2 -> this.figure = new JFigure(x, y);
            case 3 -> this.figure = new LFigure(x, y);
            case 4 -> this.figure = new OFigure(x, y);
            case 5 -> this.figure = new SFigure(x, y);
            case 6 -> this.figure = new TFigure(x, y);
            case 7 -> this.figure = new ZFigure(x, y);
        }
//        updateGUI();
    }

//    private void handleEvent(ActionEvent event) {
//        switch (event) {
//            case SHIFT_LEFT -> figure.shift(-1, 0);
//            case SHIFT_RIGHT -> figure.shift(+1, 0);
//            case SHIFT_DOWN -> figure.shift(0, -1);
//            case ROTATE_RIGHT -> figure.rotate(1);
//            case ROTATE_LEFT -> figure.rotate(-1);
//        }
//    }
    private void updateGUI() {
        gui.clear();
        gui.drawBlocks(figure.getBlocks());
    }

    private class FigureController implements ActionHandler { //new

        public void drop() {
//            TODO
        }
        public void rotateLeft() {
            figure.rotate(-1);
            updateGUI();
        }
        public void rotateRight() {
            figure.rotate(1);
            updateGUI();
        }
        public void shiftDown(){
            figure.shift(0, -1);
            updateGUI();
        }
        public void shiftLeft() {
            figure.shift(-1, 0);
            updateGUI();
        }
        public void shiftRight() {
            figure.shift(+1, 0);
            updateGUI();
        }

    }
}
