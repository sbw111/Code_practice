class Solution {
    int max = 0;
    
    public void levelOrderBottom(List<List<Integer>> ans, TreeNode root, int depth) {
        if (root == null) {
            max = Math.max(depth - 1, max);
            return;
        }
        if (ans.size() == depth) ans.add(0, new ArrayList<Integer>());
        levelOrderBottom(ans, root.left, depth + 1);
        levelOrderBottom(ans, root.right, depth + 1);
        ans.get(max - depth).add(root.val);
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        levelOrderBottom(ans, root, 0);
        return ans;
    }
}