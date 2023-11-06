import java.util.Scanner;

public class NQueens {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the board size (n): ");
        int n = scanner.nextInt();
        int[][] board = new int[n][n];

        long startTime = System.currentTimeMillis();
        if (!solveNQueens(board, 0, n)) {
            System.out.println("\nNo solution exists.");
        } else {
            long endTime = System.currentTimeMillis();
            System.out.println("\nSolution:");
            printSolution(board);
            long duration = endTime - startTime;
            System.out.println("\nTime taken: " + duration + " milliseconds");
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check the column on the left
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check the upper diagonal on the left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check the lower diagonal on the left
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int col, int n) {
        if (col == n) {
            return true;  // All Queens are placed
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;  // Place the Queen

                // Recur to place the rest of the Queens
                if (solveNQueens(board, col + 1, n)) {
                    return true;
                }

                // If placing a Queen in board[i][col] doesn't lead to a solution, backtrack
                board[i][col] = 0;
            }
        }

        // If no Queen can be placed in this column, return false
        return false;
    }

    public static void printSolution(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*Enter the board size (n): 8

Solution:
0 0 0 0 0 0 0 1 
0 0 0 0 0 1 0 0 
0 0 0 0 0 0 0 1 
0 0 0 0 1 0 0 0 
0 0 0 0 0 0 1 0 
1 0 0 0 0 0 0 0 
0 0 0 1 0 0 0 0 
0 1 0 0 0 0 0 0 

Time taken: 6 milliseconds
 */