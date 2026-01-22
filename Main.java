import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board gameBoard = new Board();
        MinimaxAi computer = new MinimaxAi();

        while (true) { 
            gameBoard.displayBoard();
            //player turn
            gameBoard.makeMove(makePlayerMove(scanner), Moves.X); //player move
            //TODO: check win


            //computer turn
            gameBoard.displayBoard();
            gameBoard.makeMove(makeComputerMove(gameBoard.getValidMoves()), Moves.O);
        }
    }

    static int makePlayerMove(Scanner scanner) {
        System.out.println("Enter move (1-9): ");
        return scanner.nextInt() - 1;
    }

    static int makeComputerMove(ArrayList<Integer> validMoves) { //for now just a random computer move
        Random rng = new Random();

        return validMoves.get(rng.nextInt(validMoves.size()));
    }
}