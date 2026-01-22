import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board gameBoard = new Board();
        MinimaxAi computer = new MinimaxAi();

        Moves playerMove = Moves.X;
        Moves computerMove = Moves.O;

        while (true) { //Game loop
            //player turn
            clearScreen();
            gameBoard.displayBoard();
            gameBoard.makeMove(makePlayerMove(gameBoard.getValidMoves(), scanner), playerMove); //player move
            if (gameBoard.hasWon(playerMove)) {
                System.out.println("Player wins!");
                break;
            }


            //computer turn
            gameBoard.makeMove(makeComputerMove(gameBoard.getValidMoves()), computerMove);
            if (gameBoard.hasWon(computerMove)) {
                System.out.println("Computer wins!");
                break;
            }
        }
    }

    static int makePlayerMove(ArrayList<Integer> validMoves, Scanner scanner) {
        int playerMove;
        
        while (true) { // gets user input
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

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}