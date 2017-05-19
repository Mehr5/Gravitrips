package gravitrips;

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

