class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null){
            TreeNode root = new TreeNode(t2.val);
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
            return root;
        }
        else if (t2 == null){
            TreeNode root = new TreeNode(t1.val);
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
            return root;
        }
        else {
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
            return root;
        }
    }
}