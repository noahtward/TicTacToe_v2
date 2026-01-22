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
            gameBoard.makeMove(makePlayerMove(gameBoard.getValidMoves(), scanner), Moves.X); //player move
            //TODO: check win


            //computer turn
            gameBoard.displayBoard();
            gameBoard.makeMove(makeComputerMove(gameBoard.getValidMoves()), Moves.O);
        }
    }

    static int makePlayerMove(ArrayList<Integer> validMoves, Scanner scanner) {
        int playerMove;
        
        while (true) { // gets user input
            System.out.println(validMoves);
            System.out.print("Enter move (1-9): ");

            try {
                playerMove = scanner.nextInt();

                if (playerMove >= 1 && playerMove <= 9) { //if valid input
                    if (validMoves.contains(playerMove - 1)) { //if input not a valid move
                        break;
                    } else {
                        System.out.println("Invalid input - Space already taken.");
                    }
                } else {
                    System.out.println("Invalid input - Number must be between 1 and 9.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input - Try again.");
                scanner.nextLine();
            }
        }

        return playerMove - 1;
    }

    static int makeComputerMove(ArrayList<Integer> validMoves) { //for now just a random computer move
        Random rng = new Random();

        return validMoves.get(rng.nextInt(validMoves.size()));
    }
}