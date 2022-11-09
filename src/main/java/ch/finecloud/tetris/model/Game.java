package ch.finecloud.tetris.model;

import ch.finecloud.tetris.Tetris;
import ch.finecloud.tetris.model.figures.*;
import tetris.gui.ActionHandler;
import tetris.gui.GUI;
import java.util.Random;

public class Game {

    private final Field field;
    private Figure figure;
    private final GUI gui;

    public Game(GUI gui) {
        this.gui = gui;
        field = new Field();
    }

    public void start() {
        createFigure();
        gui.setActionHandler(new FigureController());
    }

    public void stop() {
        this.figure = null;
        gui.setActionHandler(null);
    }

    private void createFigure() {
        int x = (Tetris.WIDTH -1) / 2;
        int y = (Tetris.HEIGHT -1);
        int figureID = new Random().nextInt(1,8);
        this.figure = switch (figureID) {
            case 1 -> new IFigure(x, y);
            case 2 -> new JFigure(x, y);
            case 3 -> new LFigure(x, y);
            case 4 -> new OFigure(x, y);
            case 5 -> new SFigure(x, y);
            case 6 -> new TFigure(x, y);
            case 7 -> new ZFigure(x, y);
            default -> throw new IllegalStateException("Unexpected value: " + figureID);
        };
        updateGUI();
    }

    private void figureLanded() {
        field.addBlocks(figure.blocks);
//        if (field.detectCollision(figure.blocks)) {
//            stop();
//        } else {
            createFigure();
//        }

    }

    private void updateGUI() {
        gui.clear();
        gui.drawBlocks(field.getBlocks());
        gui.drawBlocks(figure.getBlocks());
    }

    private class FigureController implements ActionHandler {

        @Override
        public void drop() throws CollisionException {
            while (!field.detectCollision(figure.blocks)) {
               figure.shift(0, -1);
            }
            figure.shift(0, +1);
            figureLanded();
            updateGUI();
        }

        @Override
        public void rotateLeft() throws CollisionException {
            figure.rotate(-1);
            if (field.detectCollision(figure.blocks)) {
                figure.rotate(1);
                throw new CollisionException("figure reached end of field");
            }
            updateGUI();
        }

        @Override
        public void rotateRight() throws CollisionException{
            figure.rotate(1);
            if (field.detectCollision(figure.blocks)) {
                figure.rotate(-1);
                throw new CollisionException("figure reached end of field");
            }
            updateGUI();
        }

        @Override
        public void shiftDown() throws CollisionException {
            figure.shift(0, -1);
            if (field.detectCollision(figure.blocks)) {
                figure.shift(0, +1);
                figureLanded();
            }
            updateGUI();
        }

        @Override
        public void shiftLeft() throws CollisionException {
            figure.shift(-1, 0);
            if (field.detectCollision(figure.blocks)) {
                figure.shift(+1, 0);
                throw new CollisionException("figure reached left end of field");
            }
            updateGUI();
        }

        @Override
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
