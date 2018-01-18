public class Solution {
    public int Rob(int[] nums) {
        int n = nums.Length;
        if (n == 0) return 0;
        int[,] a = new int[n,2];
        a[0,0] = 0; a[0,1] = nums[0];
        for (int i = 1; i < n; i++){
            a[i,0] = Math.Max(a[i-1,0],a[i-1,1]);
            a[i,1] = nums[i] + a[i-1,0];
        }
        return Math.Max(a[n-1,0],a[n-1,1]);
    }
}