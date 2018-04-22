import java.lang.*;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;

class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int mod = 1000000007;
        Arrays.sort(A);
        Map<Integer, Integer> number = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; ++i)
            number.put(A[i], i);
        long[] dp = new long[n];
        for (int i = 0; i < n; ++i) dp[i] = 1;
        for (int i = 0; i < n; ++i)
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] % A[j] != 0) continue;
                int mul = A[i] / A[j];
                if (number.containsKey(mul)) {
                    int index = number.get(mul);
                    dp[i] = (dp[i] + dp[index] * dp[j]) % mod;
                }
            }
        long sum = 0;
        for (int i = 0; i < n; ++i)
            sum = (sum + dp[i]) % mod;
        return (int) sum;
    }
}