public class Board {
    private final Moves[] board;
    private final int BOARD_SIZE = 9;

    public Board() {
        board = new Moves[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; ++i) { //initializes board with EMPTY objects
            board[i] = Moves.EMPTY;
        }
    }

    public void displayBoard() {
        for (Moves space : board) {
            System.out.println(space.getValue());
        }
    }
}
