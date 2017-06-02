package gravitrips;

class BotPlayer extends Player {

    public BotPlayer() {
        setChip(Chip.O);
    }

    @Override
    public int makeMove() {
        int column = (int) (Math.random() * 7.0D);
        return column;
    }
}
