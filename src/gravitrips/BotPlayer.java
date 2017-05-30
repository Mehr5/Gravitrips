package gravitrips;

class BotPlayer extends Player {

    BotPlayer(char symbol) {
        super(symbol);
    }

    public Move move(int column, int row) {
        return new Move(column, row);
    }

    @Override
    public int makeMove() {
        int column = (int) (Math.random() * 7.0D);
        return column;
    }
}
