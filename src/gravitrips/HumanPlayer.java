package gravitrips;


class HumanPlayer extends Player {
    HumanPlayer(char symbol) {
        super(symbol);
    }

    public Move move(int column, int row) {
        return new Move(column, row);
    }
}

