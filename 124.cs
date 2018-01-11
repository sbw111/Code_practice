//recursion
public class Solution {
    int max = int.MinValue;
    public int find(TreeNode root){
        if (root == null) return 0;
        int l = 0;
        int r = 0;
        if (root.left != null) l = find(root.left);
        if (root.right != null) r = find(root.right);
        if (l < 0) l = 0;
        if (r < 0) r = 0;
        if (l + r + root.val > max) max = l + r + root.val;
        return Math.Max(l, r) + root.val;
    }
    
    public int MaxPathSum(TreeNode root) {
        find(root);
        return max;
    }
}