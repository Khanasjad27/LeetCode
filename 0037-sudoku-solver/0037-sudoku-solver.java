class Solution {
    boolean isSafe(char[][] board, int row, int col, char digit) {
        // vertical
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit)
                return false;
        }

        // horizontal
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit)
                return false;
        }

        // mini grid
        int sr = (row / 3) * 3; // sr = staring row
        int sc = (col / 3) * 3; // sr = staring col

        for (int i = sr; i <= sr + 2; i++) {
            for (int j = sc; j <= sc + 2; j++) {
                if (board[i][j] == digit)
                    return false;
            }
        }

        return true;
    }
    
    boolean sudoku(char[][] board, int row, int col) {
        // BaseCase
        if (row == 9) {
            return true;
        }
        // defining nxtRow n nxtCol
        int nxtRow = row;
        int nxtCol = col + 1;
        // jaise hi last idx pe pouche wase hi nxt row pw leke jao
        if (nxtCol == 9) {
            nxtRow = row + 1;
            nxtCol = 0;
        }
        // agar curr pe already koi digit hai to aage baro
        if (board[row][col] != '.') {
            return sudoku(board, nxtRow, nxtCol);
        }

        // now we are iterating in loog n checking n placing
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (sudoku(board, nxtRow, nxtCol))
                    return true;
                board[row][col] = '.';
            }

        }
        return false;
    }


    public void solveSudoku(char[][] board) {
        sudoku(board, 0, 0);
    }
}