package gravitrips;

public abstract class Player {
    private char symbol;

    public abstract Move move(int firstVaruable, int secondVaruable);

    Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {

        return this.symbol;
    }

}
