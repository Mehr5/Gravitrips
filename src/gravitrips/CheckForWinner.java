package gravitrips;

import static gravitrips.Field.COLUMNS;
import static gravitrips.Field.ROWS;


public class CheckForWinner {


    public boolean won(Field field, Player player) {
        return this.checkVertical(field, player) || this.checkHorizontal(field, player) || this.wonGeneralDiag(field, player) || this.wonSecondDiag(field, player);
    }

    private boolean checkVertical(Field field, Player player){
        int count = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (field.getGameField(i, j) == player.getSymbol()) {
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

    private boolean checkHorizontal(Field field, Player player) {
        int count = 0;
        for (int i = 0; i < COLUMNS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (field.getGameField(j, i) == player.getSymbol()) {
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


    private boolean wonGeneralDiag(Field field,Player player) {
        int count = 0;
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < COLUMNS; j++) {
                if (field.getGameField(i, j)== player.getSymbol()) {
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


    private boolean wonSecondDiag(Field field, Player player) {
        int count = 0;
        for (int i = 4; i > 0; i--) {
            for (int j = 6; j > 0; j--) {
                if (field.getGameField(i, j)== player.getSymbol()) {
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

}
