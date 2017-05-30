package gravitrips;

import java.util.Scanner;


public class Game {
    private Scanner scanner;
    private Field field;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game() {
        scanner = new Scanner(System.in);
        field = new Field();
        player1 = new HumanPlayer('X');
        player2 = new BotPlayer('O');
    }

    public void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private void nextInputIsNotLegal(int column, int row, Player player) {
        boolean canMove = false;

        while (!canMove && !field.draw()) {
            if (!field.isLegalMove(row, column)) {
                row--;
                if (row < 0) {
                    System.out.println("This field is  busy");
                    column = currentPlayer.makeMove();
                    row = field.getRow() - 1;
                }
            }
            if (field.isLegalMove(row, column)) {
                canMove = true;
            }
            field.applyMove(player.move(column, row), player);
            changePlayer();
        }
    }

    public void run() {
        field.createNewGameField();
        int row = field.getRow() - 1;

        while (!field.won(player1) && !field.won(player2)) {
            field.printField();
            int column;

            if (!field.won(currentPlayer)) {
                changePlayer();
                column = currentPlayer.makeMove();
                if (!field.isLegalMove(row, column)) {
                    nextInputIsNotLegal(column, row, currentPlayer);
                } else {
                    field.applyMove(currentPlayer.move(column, row), currentPlayer);
                }
            }
        }
        field.printField();
        if (field.won(player1)) {
            System.out.println("Winner is - Human!");
        }
        if (field.won(player2)) {
            System.out.println("Winner is - Bot");
        }

    }


}

