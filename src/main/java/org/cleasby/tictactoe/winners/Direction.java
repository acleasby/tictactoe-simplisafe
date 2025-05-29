package org.cleasby.tictactoe.winners;

public enum Direction {
    HORIZONTAL(1, 0), VERTICAL(0, 1), DIAGONAL_UP(1, -1), DIAGONAL_DOWN(1, 1);

    final int xOffset, yOffset;

    Direction(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
