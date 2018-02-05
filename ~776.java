//recursion 
//ans[0] is small than value, ans[1] is larger than V
class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] ans = new TreeNode[2];
        if (root == null) return ans;
        if (root.val <= V){
            ans[0] = root;
            TreeNode[] p = splitBST(root.right, V);
            root.right = p[0];
            ans[1] = p[1];
        } else{
            ans[1] = root;
            TreeNode[] p = splitBST(root.left, V);
            root.left = p[1];
            ans[0] = p[0];
        }
        return ans;
    }
}