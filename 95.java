class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int begin, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (begin > end) {
            ans.add(null);
            return ans;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> left = generateTrees(begin, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode l : left)
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
        }
        return ans;
    }
}