class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int mod = 1000000007;
        int ans = 0;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int k = 0; k < N; k++) {
            int[][] tmp = new int[m][n];
            for (int i1 = 0; i1 < m; ++i1)
                for (int j1 = 0; j1 < n; ++j1)
                    for (int[] p : dir) {
                        int x = i1 + p[0];
                        int y = j1 + p[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            ans = (ans + count[i1][j1]) % mod;
                        } else {
                            tmp[x][y] = (tmp[x][y] + count[i1][j1]) % mod;
                        }
                    }
            count = tmp;
        }
        return ans;
    }
}