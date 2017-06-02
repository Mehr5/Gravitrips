package gravitrips;


public class Field {
    public static final int ROWS = 5;
    public static final int COLUMNS = 7;

    private Chip[][] gameField = new Chip[ROWS][COLUMNS];

    public Field() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                gameField[i][j] = Chip.EMPTY;
            }
        }
    }

    public Chip getGameField(int row, int column) {
        return gameField[row][column];
    }


    public int getRow() {
        return ROWS;
    }

    public int getColumn() {
        return COLUMNS;
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
        return gameField[row][column] == Chip.EMPTY;
    }

    public void applyMove(Player player) {
        gameField[getRow()][getColumn()] = player.makeMove();
    }

}


