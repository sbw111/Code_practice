class Solution {
    public void find(TreeNode root, List<String> ans, String cur){
        if (root.left == null && root.right == null) {
            ans.add(cur + root.val);
            return;
        }
        if (root.left != null) find(root.left, ans, cur + root.val + "->");
        if (root.right != null) find(root.right, ans, cur + root.val + "->");
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if (root == null) return ans;
        find(root, ans, "");
        return ans;
    }
}