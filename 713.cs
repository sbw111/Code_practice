public class Solution {
    public int NumSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int min = 0, ans = 0, p = 1;
        for (int i = 0; i < nums.Length; i++){
            p *= nums[i];
            while (p >= k) p /= nums[min++];
            ans += i - min + 1;
        }
        return ans;
    }
}