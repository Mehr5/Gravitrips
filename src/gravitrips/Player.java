package gravitrips;

public abstract class Player {
    private char symbol;

    public abstract Move move(int firstVariable, int secondVariable);

    public class Move {
        int column;
        int row;

        public Move(int column, int row) {
            this.column = column;
            this.row = row;
        }

        public int getColumn() {
            return this.column;
        }

        public int getRow() {
            return this.row;
        }
    }

    public abstract int makeMove();

    Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }



}
