class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        int sum = 0;
        if (map.containsKey(target)) return map.get(target);
        for (Integer v : nums) {
            if (target >= v) sum += combinationSum4(nums, target - v);
        }
        map.put(target, sum);
        return sum;
    }
}