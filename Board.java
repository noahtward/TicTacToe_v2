
import java.util.ArrayList;

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
        Moves squareValue;
        System.out.println("+---+---+---+");
        for (int i = 0; i < BOARD_SIZE; ++i) {
            squareValue = board[i];
            if (squareValue != Moves.EMPTY) { //if empty, put index number in the square, otherwise write X or O
                System.out.print("| " + squareValue.getValue() + " ");
            } else {
                System.out.print("| " + (i + 1) + " ");
            }
            
            if (i % 3 == 2) { //for every third value go to new line, so we display rows of 3
                System.out.println("|");
                System.out.println("+---+---+---+");
            }
        }
    }

    public void makeMove(int index, Moves move) {
        board[index] = move;
    }

    public ArrayList<Integer> getValidMoves() {
        ArrayList<Integer> validMoves = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; ++i) {
            if (board[i] == Moves.EMPTY) {
                validMoves.add(i);
            }
        }
        return validMoves;
    }
}
