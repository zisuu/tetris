package ch.finecloud.tetris.model;

import java.io.*;
import java.util.Scanner;

public class Scoring {
    private static final String HIGH_SCORE_FILE = System.getProperty("user.home") + File.separator + ".tetris.txt";
    private int highScore;
    private int removedRows;
    private static final int ROWS_PER_LEVEL = 10;
    private int score;
//    private static final int[] SCORE_REWARDS; TODO what is this meant for?


    public Scoring() {
        loadHighScore();
    }

    /**
     * Gets the high score of the game.
     * @return highScore
     */
    int getHighScore() {
        return highScore;
    }

    /**
     * Gets the current level of the game.
     * @return current level of the game
     */
    int getLevel() {
        return removedRows / ROWS_PER_LEVEL;
    }

    /**
     * Gets the current score of the game.
     */
    int getScore() {
        return score;
    }

    /**
     * Loads the high score from the high score file.
     */
    private void loadHighScore() {
        File file = new File(HIGH_SCORE_FILE);
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                String data = scanner.nextLine();
                highScore = Integer.parseInt(data);
                scanner.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Resets the level and the score of the game.
     */
    void reset() { // TODO this is never used
        this.score = 0;
        this.removedRows = 0;
    }

    /**
     * Saves the high score to the high score file.
     */
    private void saveHighScore() {
        try {
            FileWriter fileWriter = new FileWriter(HIGH_SCORE_FILE);
            fileWriter.write(String.valueOf(score));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates the high score according to the current score.
     */
    void updateHighScore() {
        highScore = score;
        saveHighScore();
    }

    /**
     * Updates the score according to the number of removed rows.
     */
    void updateScore(int numRows) {
        removedRows += numRows;
        score += switch (numRows) {
            case 1 -> 40;
            case 2 -> 100;
            case 3 -> 300;
            default -> 1200;
        };
        if (score > highScore) {
            updateHighScore();
        }
    }


}
