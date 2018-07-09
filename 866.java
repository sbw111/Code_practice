class Solution {
    TreeNode ans;
    int deep;
    public int helper(int d, TreeNode root){
        if (root == null) return 0;
        int left = helper(d+1, root.left);
        int right = helper(d+1, root.right);
        if (left == right && left + d >= deep){
            deep = left + d;
            ans = root;  
        } 
        return 1 + Math.max(left, right);
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans = root;
        helper(0, root);
        return ans;
    }
}
