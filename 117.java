public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeLinkNode next = root.right;
            TreeLinkNode rootnext = root;
            while (next == null && rootnext.next != null){
                rootnext = rootnext.next;
                if (rootnext.left == null) next = rootnext.right;
                else next = rootnext.left;
            }
            root.left.next = next;
        }
        if (root.right != null) {
            TreeLinkNode next = null;
            TreeLinkNode rootnext = root.next;
            while (next == null && rootnext != null){
                if (rootnext.left == null) next = rootnext.right;
                else next = rootnext.left;
                rootnext = rootnext.next;
            }
            root.right.next = next;
        }
        connect(root.right);
        connect(root.left);
    }
}