public class Solution {
    public bool IsValidBST(TreeNode root) {
        return IsValidBST(root, long.MinValue, long.MaxValue);
    }
    
    public bool IsValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return IsValidBST(root.left, minVal, root.val) && IsValidBST(root.right, root.val, maxVal);
    }
}