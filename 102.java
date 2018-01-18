class Solution {
    public void levelOrder(List<List<Integer>> ans, TreeNode root, int depth) {
        if (root == null) return;
        if (ans.size() == depth) ans.add(new ArrayList<Integer>());
        ans.get(depth).add(root.val);
        levelOrder(ans, root.left, depth + 1);
        levelOrder(ans, root.right, depth + 1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        levelOrder(ans, root, 0);
        return ans;
    }
}