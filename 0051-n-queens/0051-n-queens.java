class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        // Create a single row of 'n' dots
        String emptyRow = ".".repeat(n);

        // Add the row 'n' times to the board
        for (int i = 0; i < n; i++) {
            board.add(emptyRow);
        }

        nQueens(n, 0, board, ans);
        return ans;

    }

    void nQueens(int n, int row, List<String> board, List<List<String>> ans) {

        if (row == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {

            if (isSafe(n, row, col, board)) {

                // board[row][col] = 'Q'; == > yahi same step in trms of string is written below
                String currRow = board.get(row);
                String updatedRow = currRow.substring(0, col) + 'Q' + currRow.substring(col+1);
                board.set(row, updatedRow);

                // resursion
                nQueens(n, row + 1, board, ans);

                // yahi origainl row firse kardiye firse 
                board.set(row, currRow);
            }
        }
    }

    boolean isSafe(int n, int row, int col, List<String> board) {
        // vertical up wala condition
        for (int i = row-1; i >= 0; i--) {
            // if (board[i][col] == "Q") ==> yahi waale ko interms of string aise hoga

            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        // diagonal right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // diagonal left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
             if (board.get(i).charAt(j) == 'Q')  {
                return false;
            }
        }

        return true;
    }
}