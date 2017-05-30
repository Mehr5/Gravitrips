package gravitrips;


public class Field {
    public static final char EMPTY = '.';
    public static final int ROWS = 5;
    public static final int COLUMNS = 7;
    private char[][] field;

    public Field() {
        this(new char[5][7]);
    }

    public Field(char[][] field) {
        this.field = field;
    }

    public char[][] getField() {
        return this.field;
    }


    public static int getRow() {
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
                System.out.print(this.field[row][column] + " ");
            }
            System.out.println();
        }
    }

    public void createNewGameField() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.field[i][j] = EMPTY;
            }
        }
    }

    public boolean isLegalMove(int row, int column) {
        return field[row][column] == EMPTY;
    }

    public void applyMove(Player.Move m, Player player) {
        field[m.getRow()][m.getColumn()] = player.getSymbol();
    }

    public boolean won(Player player) {
        return this.checkVertical(player) || this.checkHorizontal(player) || this.wonGeneralDiag(player) || this.wonSecondDiag(player);
    }

    private boolean checkVertical(Player player) {
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                field[i][j] = new Field();
                if (getField()[i][j] == player.getSymbol()) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal(Player player) {
        int count = 0;
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (this.getField()[j][i] == player.getSymbol()) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean wonGeneralDiag(Player player) {
        int count = 0;
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < COLUMNS; j++) {
                if (this.getField()[i][j] == player.getSymbol()) {
                    count++;
                    i--;
                    if (i < 0) {
                        i = 4;
                    }
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean wonSecondDiag(Player player) {
        int count = 0;
        for (int i = 4; i > 0; i--) {
            for (int j = 6; j > 0; j--) {
                if (this.getField()[i][j] == player.getSymbol()) {
                    count++;
                    i--;
                    if (i < 0) {
                        i = 4;
                    }
                } else {
                    count = 0;
                }
                if (count == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean draw() {
        for (int row = 0; row < 51; ++row) {
            for (int column = 0; column < 7; ++column) {
                if (this.getField()[row][column] == 46) {
                    return false;
                }
            }
        }
        return true;
    }
}
