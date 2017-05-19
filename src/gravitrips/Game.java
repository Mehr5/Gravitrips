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
        botPlayer= new BotPlayer('O');
    }

    public void run() {
        this.newField.createNewGameField();
        int row = this.newField.getRow() - 1;

        do {
            this.newField.printField();
            int column;
            if (!this.newField.won(this.botPlayer)) {
                column = this.humanInput();
                if (!this.newField.isLegalMove(row, column)) {
                    this.nextInputIsNotLegal(column, row, this.humanPlayer);
                } else {
                    this.newField.applyMove(this.humanPlayer.move(column, row), this.humanPlayer);
                }
            }

            if (!this.newField.won(this.humanPlayer)) {
                column = this.computerInput();
                if (!this.newField.isLegalMove(row, column)) {
                    this.nextInputIsNotLegal(column, row, this.botPlayer);
                } else {
                    this.newField.applyMove(this.botPlayer.move(column, row), this.botPlayer);
                }
            }
        } while (!this.newField.won(this.humanPlayer) && !this.newField.won(this.botPlayer));

        this.newField.printField();
        if (this.newField.won(this.humanPlayer)) {
            System.out.println("Winner is - Human!");
        }

        if (this.newField.won(this.botPlayer)) {
            System.out.println("Winner is - Bot");
        } else {
            System.out.println("Draw!");
        }

    }

    private int humanInput() {
        System.out.print("Enter column from 1 to 7: ");
        int column = this.scanner.nextInt();
        --column;
        return column;

    }

    private int computerInput() {
        int column = (int) (Math.random() * 7.0D);
        return column;
    }

    private void nextInputIsNotLegal(int column, int row, Player player) {
        boolean canMove = false;

        do {
            if(player == this.humanPlayer && !this.newField.isLegalMove(row, column)) {
               row --;
                if(row < 0) {
                    System.out.println("This field is busy!");
                    column = this.humanInput();
                    row = this.newField.getRow() - 1;
                }
            } else if(player == this.botPlayer && !this.newField.isLegalMove(row, column)) {
                --row;
                if(row < 0) {
                    column = this.computerInput();
                    row = this.newField.getRow() - 1;
                }
            }

            if(this.newField.isLegalMove(row, column)) {
                canMove = true;
            }
        } while(!canMove && !this.newField.draw());

        this.newField.applyMove(player.move(column, row), player);
    }

}

