class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = -1;
        int r = -1;
        int max = nums[0];
        int min = nums[n-1];
        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            if (max > nums[i]) r = i;
        }
        for (int i = n - 1; i >= 0; i--){
            min = Math.min(min, nums[i]);
            if (min < nums[i]) l = i;
        }
        if (l == -1) return 0;
        else return r - l + 1;
    }
}