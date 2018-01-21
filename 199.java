class Solution {
    public void find(List<Integer> ans, TreeNode root, int depth){
        if (root == null) return;
        if (depth == ans.size()) ans.add(root.val);
        find(ans, root.right, depth + 1);
        find(ans, root.left, depth + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        find(ans, root, 0);
        return ans;
    }
}