class Solution {
    public void find(int[] nums, List<List<Integer>> ans, List<Integer> cur, boolean[] flag, int total) {
        if (total == nums.length) {
            ans.add(new ArrayList<Integer>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            flag[i] = true;
            cur.add(nums[i]);
            find(nums, ans, cur, flag, total + 1);
            flag[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean[] flag = new boolean[nums.length];
        find(nums, ans, new ArrayList<Integer>(), flag, 0);
        return ans;
    }
}