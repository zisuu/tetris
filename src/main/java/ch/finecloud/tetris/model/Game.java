package ch.finecloud.tetris.model;

import ch.finecloud.tetris.Tetris;
import ch.finecloud.tetris.model.figures.*;
import tetris.gui.ActionHandler;
import tetris.gui.GUI;
import java.util.Random;

/**
 * The class Game implements the Tetris game.
 *
 */
public class Game {

    /**
     * The graphical user interface.
     */
    private final GUI gui;

    /**
     * The figure of the game.
     */
    private Figure figure;

    /**
     * The field of the game.
     */
    private final Field field;

    /**
     * The scoring of the game.
     */
    private final Scoring scoring;

    /**
     * Constructs a game with a graphical user interface.
     *
     * @param gui the graphical user interface
     */
    public Game(GUI gui) {
        this.gui = gui;
        field = new Field();
        scoring = new Scoring();
    }

    /**
     * Starts the game by creating a figure and registering an action handler.
     */
    public void start() {
        createFigure();
        gui.setActionHandler(new FigureController());
    }

    /**
     * Stops the game by clearing the latest figure and unregistering the action handler.
     */
    public void stop() {
        this.figure = null;
        gui.setActionHandler(null);
    }

    /**
     * Creates a random figure at the top of the field.
     */
    private void createFigure() {
        int x = (Tetris.WIDTH -1) / 2;
        int y = (Tetris.HEIGHT -1);
        int figureID = new Random().nextInt(1,8);
        figure = switch (figureID) {
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

    /**
     * Updates the graphical user interface according to the current state of the game.
     */
    private void updateGUI() {
        gui.clear();
        gui.drawBlocks(field.getBlocks());
        gui.drawBlocks(figure.getBlocks());
        gui.setLevel(scoring.getLevel());
        gui.setScore(scoring.getScore());
        gui.setHighScore(scoring.getHighScore());
    }

    /**
     * Lands figure in the field of the game.
     */
    private void figureLanded() {
        field.addBlocks(figure.blocks);
        int removedRows = field.removeFullRows();
        if (removedRows > 0) {
            scoring.updateScore(removedRows);
        }
        createFigure();
        if (field.detectCollision(figure.getBlocks())) {
            stop();
        }
    }

    /**
     * The class FigureController is used to control the figure of the Tetris game.
     *
     */
    private class FigureController implements ActionHandler {

        /**
         * Drops the figure.
         */
        @Override
        public void drop() {
            while (!field.detectCollision(figure.getBlocks())) {
               figure.shift(0, -1);
            }
            figure.shift(0, +1);
            figureLanded();
        }

        /**
         * Rotates the figure to the left.
         */
        @Override
        public void rotateLeft() throws CollisionException {
            figure.rotate(-1);
            if (field.detectCollision(figure.blocks)) {
                figure.rotate(1);
                throw new CollisionException("figure reached end of field");
            }
            updateGUI();
        }

        /**
         * Rotates the figure to the right.
         */
        @Override
        public void rotateRight() throws CollisionException{
            figure.rotate(1);
            if (field.detectCollision(figure.blocks)) {
                figure.rotate(-1);
                throw new CollisionException("figure reached end of field");
            }
            updateGUI();
        }

        /**
         * Shifts the figure down.
         */
        @Override
        public void shiftDown() {
            figure.shift(0, -1);
            if (field.detectCollision(figure.blocks)) {
                figure.shift(0, +1);
                figureLanded();
            } else {
                updateGUI();
            }
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
