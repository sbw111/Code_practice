public class Solution {
    public int find(TreeNode root, int sum){
        int ans = 0;
        if (root == null) return 0;
        if (sum == root.val) ++ans;
        return ans + find(root.left, sum - root.val) + find(root.right, sum - root.val);
    }
    
    public int PathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return find(root, sum) + PathSum(root.left, sum) + PathSum(root.right, sum);
    }
    
}