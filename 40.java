class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public void find(int[] nums, int target, int index, ArrayList<Integer> condition) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(condition));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (target >= nums[i]) {
                condition.add(nums[i]);
                find(nums, target - nums[i], i + 1, condition);
                condition.remove(condition.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(candidates, target, 0, new ArrayList<Integer>());
        return ans;
    }
}