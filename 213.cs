public class Solution {
    public int Rob(int[] nums,int left, int right){
        if (right < left) return 0;
        int include = 0;
        int exclude = 0;
        for (int i = left; i <= right; i++){
            int temp = Math.Max(include, exclude);
            include = nums[i] + exclude;
            exclude = temp;
        }
        return Math.Max(include, exclude);
    }
    
    public int Rob(int[] nums) {
        int n = nums.Length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.Max(Rob(nums, 0, n - 2), Rob(nums, 1, n - 1));
    }
}