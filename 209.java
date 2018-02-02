class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        while (r < nums.length){
            count += nums[r];
            r++;
            if (count >= s){
                while (count >= s){
                    min = Math.min(r - l, min);
                    count -= nums[l];
                    l++;
                }
            }
        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }
}