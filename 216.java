class Solution {
    public void find(List<List<Integer>> ans, List<Integer> cur, int max, int sum, int k, int n){
        if (sum > n) return;
        if (cur.size() == k){
            if (sum == n) ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = max + 1; i < 10; ++i){
            cur.add(i);
            find(ans, cur, i, sum + i, k ,n);
            cur.remove(cur.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        find(ans, new ArrayList<Integer>(), 0, 0, k, n);
        return ans;
    }
}