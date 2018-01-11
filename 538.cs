public class Solution {
    int sum = 0;
    public void change(TreeNode root){
        if (root == null) return;
        change(root.right);
        root.val +=sum;
        sum = root.val;
        change(root.left);
    }
    
    public TreeNode ConvertBST(TreeNode root) {
        change(root);
        return root;
    }
}