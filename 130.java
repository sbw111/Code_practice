class Solution {
    public void find(char[][] board, boolean[][] record, int x, int y) {
        record[x][y] = true;
        if (x > 0 && board[x - 1][y] == 'O' && !record[x - 1][y]) find(board, record, x - 1, y);
        if (y > 0 && board[x][y - 1] == 'O' && !record[x][y - 1]) find(board, record, x, y - 1);
        if (x < board.length - 1 && board[x + 1][y] == 'O' && !record[x + 1][y]) find(board, record, x + 1, y);
        if (y < board[0].length - 1 && board[x][y + 1] == 'O' && !record[x][y + 1]) find(board, record, x, y + 1);
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int n = board.length;
        int m = board[0].length;
        boolean[][] record = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (!record[i][0] && board[i][0] == 'O') find(board, record, i, 0);
            if (!record[i][m - 1] && board[i][m - 1] == 'O') find(board, record, i, m - 1);
        }
        for (int j = 1; j < m - 1; j++) {
            if (!record[0][j] && board[0][j] == 'O') find(board, record, 0, j);
            if (!record[n - 1][j] && board[n - 1][j] == 'O') find(board, record, n - 1, j);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (record[i][j]) continue;
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
    }
}