class Solution {
    public void dfs(char[][] grid, boolean[][] flag, int i, int j) {
        if (grid[i][j] == '0' || flag[i][j]) return;
        flag[i][j] = true;
        if (i > 0) dfs(grid, flag, i - 1, j);
        if (j > 0) dfs(grid, flag, i, j - 1);
        if (i < grid.length - 1) dfs(grid, flag, i + 1, j);
        if (j < grid[0].length - 1) dfs(grid, flag, i, j + 1);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!flag[i][j] && grid[i][j] == '1') {
                    dfs(grid, flag, i, j);
                    count++;
                }
        return count;
    }
}