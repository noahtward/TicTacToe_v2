public class Board {
    private final Moves[] board;
    private final int BOARD_SIZE = 9;

    public Board() {
        board = new Moves[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; ++i) { //initializes board with EMPTY objects
            board[i] = Moves.EMPTY;
        }
    }

    public void displayBoard() { //nicely displays the board as a 2d grid 3x3
        System.out.println("+---+---+---+");
        for (int i = 0; i < BOARD_SIZE; ++i) {
            System.out.print("| " + board[i].getValue() + " ");
            if (i % 3 == 2) { //for every third value go to new line, so we display rows of 3
                System.out.println("|");
                System.out.println("+---+---+---+");
            }
        }
    }
}
