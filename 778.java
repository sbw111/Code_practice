class Solution {
    public void dfs(int[][] grid, boolean[][] map, int[][] min, int i, int j) {
        if (i == grid.length - 1 && j == grid.length - 10) {
            return;
        }
        if (i > 0 && !map[i - 1][j] && Math.max(min[i][j], grid[i - 1][j]) < min[i - 1][j]) {
            map[i - 1][j] = true;
            min[i - 1][j] = Math.max(min[i][j], grid[i - 1][j]);
            dfs(grid, map, min, i - 1, j);
            map[i - 1][j] = false;
        }
        if (j > 0 && !map[i][j - 1] && Math.max(min[i][j], grid[i][j - 1]) < min[i][j - 1]) {
            map[i][j - 1] = true;
            min[i][j - 1] = Math.max(min[i][j], grid[i][j - 1]);
            dfs(grid, map, min, i, j - 1);
            map[i][j - 1] = false;
        }
        if (i < grid.length - 1 && !map[i + 1][j] && Math.max(min[i][j], grid[i + 1][j]) < min[i + 1][j]) {
            map[i + 1][j] = true;
            min[i + 1][j] = Math.max(min[i][j], grid[i + 1][j]);
            dfs(grid, map, min, i + 1, j);
            map[i + 1][j] = false;
        }
        if (j < grid.length - 1 && !map[i][j + 1] && Math.max(min[i][j], grid[i][j + 1]) < min[i][j + 1]) {
            map[i][j + 1] = true;
            min[i][j + 1] = Math.max(min[i][j], grid[i][j + 1]);
            dfs(grid, map, min, i, j + 1);
            map[i][j + 1] = false;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] min = new int[n][n];
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                min[i][j] = Integer.MAX_VALUE;
        min[0][0] = grid[0][0];
        dfs(grid, map, min, 0, 0);
        return min[n - 1][n - 1];
    }
}