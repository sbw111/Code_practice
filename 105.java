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
    public int find(int l, int r, int need, int[] a) {
        for (int i = l; i <= r; i++) if (a[i] == need) return i;
        return -1;
    }
    
    public TreeNode help(int inb, int ind, int pb, int pd, int[] inorder, int[] preorder) {
        if (inb > ind || pb > pd) return null;
        TreeNode root = new TreeNode(preorder[pb]);
        int index = find(inb, ind, preorder[pb], inorder);
        root.left = help(inb, index - 1, pb + 1, pb + (index - inb), inorder, preorder);
        root.right = help(index + 1, ind, pd - (ind - index) + 1, pd, inorder, preorder);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = inorder.length;
        return help(0, l - 1, 0, l - 1, inorder, preorder);
    }
}