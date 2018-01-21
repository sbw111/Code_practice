class Solution {
    public TreeNode help(int[] nums, int l, int r){
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, l, mid - 1);
        root.right = help(nums, mid + 1, r);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        return help(nums, 0, n - 1);
    }
}