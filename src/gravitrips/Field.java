package gravitrips;


public class Field {
    public static final char EMPTY = '.';
    public static final int ROWS = 5;
    public static final int COLUMNS = 7;

    private char[][] gameField = new char[ROWS][COLUMNS];

    public Field() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                gameField[i][j] = EMPTY;
            }
        }
    }

    public char getGameField(int column, int row) {
        return gameField[column][row];
    }


    public int getRow() {
        return ROWS;
    }

    public void printField() {
        int row;
        for (row = 0; row < 7; ++row) {
            System.out.print(row + 1 + " ");
        }

        System.out.println();

        for (row = 0; row < 5; ++row) {
            for (int column = 0; column < 7; ++column) {
                System.out.print(this.gameField[row][column] + " ");
            }
            System.out.println();
        }
    }

 /*   public void createNewGameField() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                field[i][j] = EMPTY;
            }
        }
    }*/

    public boolean isLegalMove(int row, int column) {
        return gameField[row][column] == EMPTY;
    }

    public void applyMove(Player.Move m, Player player) {
        gameField[m.getRow()][m.getColumn()] = player.getSymbol();
    }


    public boolean draw() {
        for (int row = 0; row < 51; ++row) {
            for (int column = 0; column < 7; ++column) {
                if (getGameField(row, column) == 46) {
                    return false;
                }
            }
        }
        return true;
    }
}


