package ch.finecloud.tetris.model;

import ch.finecloud.tetris.model.figures.*;
import tetris.gui.ActionHandler;
import tetris.gui.GUI;

import java.util.Random;

public class Game {

    private final Field field;
    private Figure figure;
    private final GUI gui;
    private final int width;
    private final int height;


    public Game(int width, int height, GUI gui) {
        this.width = width;
        this.height = height;
        field = new Field(this.width, this.height);
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

        public void drop() throws CollisionException {
            int lowestBlockPositionY = 0;
            // get the lowest block position, this tells us the diff from y pos to filed bottom y = 0
            for (int i = 0; i < figure.blocks.length -1; i++) {
                lowestBlockPositionY = Math.min(figure.blocks[i].y, figure.blocks[i + 1].y);
//                lowestBlockPositionY = figure.blocks[i].y > figure.blocks[i+1].y ? figure.blocks[i+1].y : figure.blocks[i].y;
            }
            // shift all blocks down with diff
            figure.shift(0, -lowestBlockPositionY);
            if (field.detectCollision(figure.blocks)) {
                figure.shift(0, +lowestBlockPositionY);
                throw new CollisionException("figure reached end of field");
            }
            updateGUI();
        }
        public void rotateLeft() throws CollisionException {
            figure.rotate(-1);
            if (field.detectCollision(figure.blocks)) {
                figure.rotate(1);
                throw new CollisionException("figure reached end of field");
            }
            updateGUI();
        }
        public void rotateRight()  throws CollisionException{
            figure.rotate(1);
            if (field.detectCollision(figure.blocks)) {
                figure.rotate(-1);
                throw new CollisionException("figure reached end of field");
            }
            updateGUI();
        }
        public void shiftDown() throws CollisionException {
            figure.shift(0, -1);
            if (field.detectCollision(figure.blocks)) {
                figure.shift(0, +1);
                throw new CollisionException("figure reached bottom end of field");
            }
            updateGUI();
        }
        public void shiftLeft() throws CollisionException {
            figure.shift(-1, 0);
            if (field.detectCollision(figure.blocks)) {
                figure.shift(+1, 0);
                throw new CollisionException("figure reached left end of field");
            }
            updateGUI();
        }
        public void shiftRight() throws CollisionException {
            figure.shift(+1, 0);
            if (field.detectCollision(figure.blocks)) {
                figure.shift(-1, 0);
                throw new CollisionException("figure reached right end of field");
            }
            updateGUI();
        }

    }
}
