package org.example;

import java.io.IOException;
import java.util.*;

public class KeypadDecoder {

    private static final char[][] KEYPAD = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P'}
    };

    private static final Map<Direction, int[]> MOVES = Map.of(
            Direction.UP,    new int[]{-1, 0},
            Direction.DOWN,  new int[]{1, 0},
            Direction.LEFT,  new int[]{0, -1},
            Direction.RIGHT, new int[]{0, 1}
    );

    private static final int ROWS = KEYPAD.length;
    private static final int COLS = KEYPAD[0].length;

    public static String decodeSequence(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.strip().split("\\R"); // Split by newlines

        for (String line : lines) {
            result.append(processLine(line));
        }

        return result.toString();
    }

    private static char processLine(String line) {
        int row = 0, col = 0; // Start at 'A'

        for (String moveStr : line.split(",")) {
            Direction move = Direction.fromString(moveStr.trim());
            if (move == null) continue;

            int newRow = row + MOVES.get(move)[0];
            int newCol = col + MOVES.get(move)[1];

            if (isValid(newRow, newCol)) {
                row = newRow;
                col = newCol;
            }
        }

        return KEYPAD[row][col];
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT;

        public static Direction fromString(String s) {
            try {
                return Direction.valueOf(s.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        try {
            String fileContent = DatasetReader.readFromResource("hyperskill-dataset.txt");
            System.out.println("Decoded: " + decodeSequence(fileContent));

        } catch (IOException e) {
            System.err.println("Reading file failed: " + e.getMessage());
        }
    }
}