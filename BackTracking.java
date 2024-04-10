import java.util.ArrayList;

class BackTracking {

    public static void main(String[] args) {
        // N Queen Problem
        // int n = 4;
        // ArrayList<ArrayList<Integer>> ans = nQueen(n);
        // for (ArrayList<Integer> a : ans) {
        // System.out.println(a);
        // }

        // Solve Sudoku
        // int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0
        // }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        // { 0, 0, 3, 0, 0, 0, 1, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0,
        // 9, 0, 6, 0, 0 },
        // { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2,
        // 0, 6, 3, 0, 0 } };
        // if (SolveSudoku(grid)) {
        // printGrid(grid);
        // } else {
        // System.out.println("No Solution");
        // }

        // is Valid Sudoku
        int[][] mat = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
        System.out.println(isValid(mat));

    }

    // N Queen Problem
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(board, 0, ans);

        return ans;
    }

    static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q')
                return false;
            if (board[i][col] == 'Q')
                return false;
        }

        int c = col;
        for (int r = row; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q')
                return false;
        }

        c = col;
        for (int r = row; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q')
                return false;

        }

        return true;
    }

    public static void solve(char[][] board, int row, ArrayList<ArrayList<Integer>> ans) {
        int n = board.length;
        if (row == n) {
            ArrayList<Integer> subAnswer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'Q') {
                        subAnswer.add(j + 1);
                    }
                }
            }
            ans.add(new ArrayList<>(subAnswer));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                solve(board, row + 1, ans);
                board[row][i] = '.';
            }
        }
    }

    // Solve Sudoku
    static boolean SolveSudoku(int grid[][]) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 1; k <= n; k++) {
                        if (isValid(grid, i, j, k)) {
                            grid[i][j] = k;
                            if (SolveSudoku(grid))
                                return true;
                            grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }

    static boolean isValid(int[][] grid, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == val)
                return false;
            if (grid[i][col] == val)
                return false;
            if (grid[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val)
                return false;

        }
        return true;
    }

    static void printGrid(int grid[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int isValid(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != 0) {
                    int temp = mat[i][j];
                    mat[i][j] = 0;
                    if (!isCorrect(mat, i, j, temp)) {
                        return 0;
                    }
                    mat[i][j] = temp;
                }
            }
        }
        return 1;
    }

    static boolean isCorrect(int[][] mat, int row, int col, int val) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] == val)
                return false;
            if (mat[row][i] == val)
                return false;
            if (mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val)
                return false;
        }
        return true;
    }
}