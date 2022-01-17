public class Sudoku {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {

        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (solve(board)) {
            System.out.println("Solved!");
            printBoard(board);
        }
        else {
            System.out.println("No solution exists!");
        }
    }

    private static boolean isInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInCol(int[][] board, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxCol = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxCol; j < localBoxCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean isValid(int[][] board, int number, int row, int column) {
        return !isInRow(board, number, row) && !isInCol(board, number, column) && !isInBox(board, number, row, column);
    }

    private static boolean solve(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0) {
                    for (int number = 1; number <= GRID_SIZE; number++) {
                        if (isValid(board, number, i, j)) {
                            board[i][j] = number;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (i % 3 == 0) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    System.out.print("---");
                }
                System.out.print("-");
                System.out.println("");
            }
            for (int j = 0; j < GRID_SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("|");
                    System.out.print(" " + board[i][j] + " ");

                }
                    
                 else {
                    System.out.print(" " + board[i][j] + " ");

                }
            }
            System.out.println(" ");

            
        }
        for (int j = 0; j < GRID_SIZE; j++) {
            System.out.print("---");
        }
        System.out.print("-");
    }
}