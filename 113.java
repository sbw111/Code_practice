class Solution {
    public void find(List<List<Integer>> ans, List<Integer> cur, TreeNode root, int sum, int target){
        if (root.left == null && root.right == null){
            if (target == sum + root.val) {
                cur.add(root.val);
                ans.add(new ArrayList<Integer>(cur)); 
                cur.remove(cur.size() - 1);
            }
            return;
        }
        cur.add(root.val);
        if (root.left != null) find(ans, cur, root.left, sum + root.val, target);
        if (root.right != null) find(ans, cur, root.right, sum + root.val, target);
        cur.remove(cur.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        if (root == null) return ans;
        find(ans, cur, root, 0, sum);
        return ans;
    }
}