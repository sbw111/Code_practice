class Solution {
    public int find(int l, int r, int need, int[] a) {
        for (int i = l; i <= r; i++) if (a[i] == need) return i;
        return -1;
    }

    public TreeNode help(int inb, int ind, int pb, int pd, int[] inorder, int[] postorder) {
        if (inb > ind || pb > pd) return null;
        TreeNode root = new TreeNode(postorder[pd]);
        int index = find(inb, ind, postorder[pd], inorder);
        root.left = help(inb, index - 1, pb, pd - (ind - index) - 1, inorder, postorder);
        root.right = help(index + 1, ind, pd - (ind - index), pd - 1, inorder, postorder);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int l = inorder.length;
        return help(0, l - 1, 0, l - 1, inorder, postorder);
    }
}