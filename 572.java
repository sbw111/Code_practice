class Solution {
    public boolean check(TreeNode r1, TreeNode r2){
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) return false;
        return check(r1.left, r2.left) && check(r1.right, r2.right);
    }
    
    public boolean find(TreeNode s, TreeNode t){
        if (s == null) return false;
        boolean flag = false;
        if (s.val == t.val) flag = check(s, t);
        if (flag) return true;
        else return find(s.left, t) || find(s.right, t);
    }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        else return find(s, t);
    }
}