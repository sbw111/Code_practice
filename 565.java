class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] flag = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i){
            if (flag[i]) continue;
            Set<Integer> s = new HashSet<Integer>();
            int j = i;
            while (!s.contains(j)){
                s.add(j); flag[j] = true;
                j = nums[j];
            }
            ans = Math.max(ans, s.size());
        }
        return ans;
    }
}