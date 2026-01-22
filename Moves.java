public enum Moves {
    X('X'),
    O('O'),
    EMPTY(' ');

    private final char value;

    Moves(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}