package dz5;

/*3**. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
        (обратите внимание на алгоритм backtracking(поиск с возвратом)).
 */
public class task02 {
    private static final int boardSize = 8;
    private static boolean canPlaceQueen(int row, int column, int[] board) {
        for (int i = 0; i < row; i++) {
            int j = board[i];
            if (j == column || i + j == row + column || i - j == row - column) {
                return false;
            }
        }
        return true;
    }

    private static void placeQueens(int row, int[] board) {
        if (row == boardSize) {
            printSolution(board);
            return;
        }
        for (int column = 0; column < boardSize; column++) {
            if (canPlaceQueen(row, column, board)) {
                board[row] = column;
                placeQueens(row + 1, board);
            }
        }
    }

    private static void printSolution(int[] board) {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] board = new int[boardSize];
        placeQueens(0, board);
    }
}

