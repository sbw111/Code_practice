class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> totalsum = new ArrayList<List<Integer>>();
        int n = nums.length;
        if (n < 3) return totalsum;
        Arrays.sort(nums);
        if (nums[0] > 0) return totalsum;
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            int sum;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    totalsum.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) ++j;
                else --k;
            }
        }
        return totalsum;
    }
}