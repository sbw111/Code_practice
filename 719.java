class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int[] a = new int[1000000];
        int n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                a[Math.abs(nums[i] - nums[j])]++;
        int sum = 0;
        int i;
        for (i = 0; i < 1000000; i++) {
            sum += a[i];
            if (sum >= k) break;
        }
        return i;
    }
}