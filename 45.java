class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = 0;
        int last = 0;
        for (int i = 0; i < n - 1; i++){
            max = Math.max(max, i + nums[i]);
            if (i == last){
                last = max; count++;
            }
        }
        return count;
    }
}