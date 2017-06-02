package gravitrips;

public abstract class Player {
    private Chip chip;

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public Chip getChip() {
        return chip;
    }

    public abstract int makeMove();

}
