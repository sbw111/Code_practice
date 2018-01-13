class Solution {
    TreeNode pre;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference(root.left);
        if (pre != null) min = Math.min(min, root.val - pre.val);
        pre = root;
        getMinimumDifference(root.right);
        return min;
    }
}