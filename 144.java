/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> l = new Stack<TreeNode>();
        Stack<TreeNode> r = new Stack<TreeNode>();
        if (root == null) return ans;
        l.push(root);
        TreeNode node;
        while (!l.empty() || !r.empty()){
            if (!l.empty()) node = l.pop();
            else node = r.pop();
            ans.add(node.val);
            if (node.left != null) l.push(node.left);
            if (node.right != null) r.push(node.right);
        }
        return ans;
    }
}