class Solution {
    public int deepleft(TreeNode root){
        int ans = 0;
        while (root != null){
            root = root.left;
            ++ans;
        }
        return ans;
    }
    
    public int deepright(TreeNode root){
        int ans = 0;
        while (root != null){
            root = root.right;
            ++ans;
        }
        return ans;
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = deepleft(root);
        int r = deepright(root);
        if (l == r) return (1 << l) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}