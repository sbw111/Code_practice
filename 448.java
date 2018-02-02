class Solution {
    // public List<Integer> findDisappearedNumbers(int[] nums) {
    //     List<Integer> ans = new ArrayList<>();
    //     int[] a = new int[nums.length + 1];
    //     for (int n: nums) a[n]++;
    //     for (int i = 1; i <=nums.length; i++){
    //         if (a[i] == 0) ans.add(i);
    //     }
    //     return ans;
    // }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i){
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0){
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; ++i){
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}