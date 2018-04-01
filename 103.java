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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> tmp = new ArrayList<Integer>();
            int count = q.size();
            for (int i = 0; i < count; i++){
                TreeNode node = q.poll();
                if (ans.size() % 2 == 0) tmp.add(node.val);
                else tmp.add(0, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(tmp);
        }
        return ans;
    }
}