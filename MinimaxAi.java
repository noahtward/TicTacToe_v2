import java.util.ArrayList;

public class MinimaxAi {
    

    private boolean checkWin(Board board) {
        return (board.hasWon(Moves.X) || board.hasWon(Moves.O));
    }

    private double evaluateScore(Board board) { //evaluate score, only if someone has won
        if (board.hasWon(Moves.O)) {
            return 1.0;
        } else if (board.hasWon(Moves.X)) {
            return -1.0;
        } else {
            return 0.0;
        }
    }

    private Moves opponent(Moves player) {
        return player == Moves.X ? Moves.O : Moves.X;
    }

    public double[] minimax(Board board, int depth, Moves player) {
        ArrayList<Integer> availableMoves = board.getValidMoves();

        if (checkWin(board) || availableMoves.isEmpty() || depth == 0) {
            return new double[] { -1, evaluateScore(board) };
        }

        double[] bestMove;
        if (player == Moves.O) {
            bestMove = new double[] { -1, Double.NEGATIVE_INFINITY };
        } else {
            bestMove = new double[] { -1, Double.POSITIVE_INFINITY };
        }

        for (int move : availableMoves) {
            board.makeMove(move, player);

            double[] result = minimax(board, depth - 1, opponent(player));

            board.makeMove(move, Moves.EMPTY);

            result[0] = move;

            if (player == Moves.O) {
                if (result[1] > bestMove[1]) {
                    bestMove = result;
                }
            } else {
                if (result[1] < bestMove[1]) {
                    bestMove = result;
                }
            }
        }

        return bestMove;
    }
    
}
