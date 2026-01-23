import java.util.ArrayList;
import java.util.Scanner;

/*
*
*   TODO:
*
*   1. Allow check win to account for ties/cat's games
*   2. Prototype minimax ai function
*   3. Create minimax ai in it's class file, and then implement it in Main.java
*
*
*
*/

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
                clearScreen();
                gameBoard.displayBoard();
                System.out.println("Player wins!");
                break;
            } else if (gameBoard.isTie()) {
                clearScreen();
                gameBoard.displayBoard();
                System.out.println("It's a tie!");
                break;
            }


            //computer turn
            gameBoard.makeMove(makeComputerMove(gameBoard.getValidMoves(), gameBoard, computer), computerMove);
            if (gameBoard.hasWon(computerMove)) {
                clearScreen();
                gameBoard.displayBoard();
                System.out.println("Computer wins!");
                break;
            } else if (gameBoard.isTie()) {
                clearScreen();
                gameBoard.displayBoard();
                System.out.println("It's a tie!");
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

    static int makeComputerMove(ArrayList<Integer> validMoves, Board board, MinimaxAi computer) { //for now just a random computer move
        int depth = validMoves.size();
        double[] bestMove = computer.minimax(board, depth, Moves.O);
        return (int) bestMove[0];
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}