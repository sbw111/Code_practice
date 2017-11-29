public class Solution {
    public int[] CountBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i/2] + (i % 2);
        return f;
    }
}