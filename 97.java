# DP
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        boolean[][] a = new boolean[n + 1][m + 1];
        a[0][0] = true;
        if (n + m != s3.length()) return false;
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++){
                if (i == 0 && j == 0) continue;
                if (i == 0){
                    a[i][j] = a[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
                else if (j == 0){
                    a[i][j] = a[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                else a[i][j] = (a[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (a[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        return a[n][m];
    }
}
