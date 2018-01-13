class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> a = new HashMap<Integer, Integer>();
        int sum = 0;
        int max = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0) sum--;
            else sum++;
            if (sum == 0) max = Math.max(max,i+1);
            else {
                if (a.containsKey(sum)) max=Math.max(max,i-a.get(sum));
                if (a.containsKey(sum)) a.replace(sum,Math.min(a.get(sum),i));
                else{
                    a.put(sum,i);
                }
            }
        }
        return max;
    }
}