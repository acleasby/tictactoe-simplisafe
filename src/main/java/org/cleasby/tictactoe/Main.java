package org.cleasby.tictactoe;

import java.util.Random;

/**
 * Plays a game of Tic Tac Toe.  Moves are randomly generated and play continues until a player wins (e.g., a win
 * condition is satisfied) or there are no more moves available.
 */
public class Main {
    public static void main(String[] args) {
        int width = 4;
        int height = 4;
        TicTacToe game = new TicTacToe(width, height);

        // Execute game, starting with RED, until a win condition is reached or the board is full.
        Square mover = Square.RED;
        Random r = new Random();
        while (game.anyMovesLeft()) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            while (!game.makeMove(x, y, mover)) {
                x = r.nextInt(width);
                y = r.nextInt(height);
            }
            System.out.println(mover + " made move at " + x + ", " + y);
            if (game.isGameOver()) {
                break;
            }
            mover = mover == Square.RED ? Square.BLACK : Square.RED;
        }
        Winner winner = game.checkWinner();
        System.out.println(game.checkWinner() != null ? "Winner is " + mover + " by " + winner : "Draw");
        System.out.println(game);
    }
}