package gravitrips;
import java.util.Scanner;


public class Game {
    private Scanner scanner;
    private Field newField;
    private Player humanPlayer;
    private Player botPlayer;

    public Game() {
        scanner = new Scanner(System.in);
        newField = new Field();
        humanPlayer = new HumanPlayer('X');
        botPlayer = new BotPlayer('O');
    }

    public void run() {
        newField.createNewGameField();
        int row = newField.getRow() - 1;

        do {
            newField.printField();
            int column;
            if (!newField.won(this.botPlayer)) {
                column = humanPlayer.makeMove();
                if (!newField.isLegalMove(row, column)) {
                    this.nextInputIsNotLegal(column, row, humanPlayer);
                } else {
                    this.newField.applyMove(humanPlayer.move(column, row), humanPlayer);
                }
            }

            if (!this.newField.won(humanPlayer)) {
                column = this.botPlayer.makeMove();
                if (!this.newField.isLegalMove(row, column)) {
                    this.nextInputIsNotLegal(column, row, botPlayer);
                } else {
                   newField.applyMove(botPlayer.move(column, row), botPlayer);
                }
            }
        } while (!newField.won(humanPlayer) && !newField.won(botPlayer));

        newField.printField();
        if (newField.won(humanPlayer)) {
            System.out.println("Winner is - Human!");
        }

        if (newField.won(this.botPlayer)) {
            System.out.println("Winner is - Bot");
        }

    }

/*    private int humanInput() {

        System.out.print("Enter column from 1 to 7: ");
        int column = this.scanner.nextInt();

        while (column < 1 || column > 7) {

            System.out.println("The number you have entered does not meet the requirements.");
            System.out.println(" Please choose number between 1 and 7");
            column = this.scanner.nextInt();

            if (column >= 1 && column <= 7) {
                break;
            }
        }
        column--;
        return column;
    }*/

/*
    private int computerInput() {
        int column = (int) (Math.random() * 7.0D);
        return column;
    }
*/

    private void nextInputIsNotLegal(int column, int row, Player player) {
        boolean canMove = false;

        do {
            if (player == humanPlayer && !newField.isLegalMove(row, column)) {
                row--;
                if (row < 0) {
                    System.out.println("This field is busy!");
                    column = humanPlayer.makeMove();
                    row = newField.getRow() - 1;
                }
            } else if (player == this.botPlayer && !newField.isLegalMove(row, column)) {
                row--;
                if (row < 0) {
                    column = botPlayer.makeMove();
                    row = newField.getRow() - 1;
                }
            }

            if (newField.isLegalMove(row, column)) {
                canMove = true;
            }
        } while (!canMove && !newField.draw());

        newField.applyMove(player.move(column, row), player);
    }

}

