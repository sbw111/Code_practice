class Solution {
    public TreeNode toBst(int[] nums, int l, int r) {
        if (l == r) return null;
        int mid = (l + r) / 2;
        TreeNode p = new TreeNode(nums[mid]);
        p.left = toBst(nums, l, mid);
        p.right = toBst(nums, mid + 1, r);
        return p;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> tmp = new ArrayList<Integer>();
        while (head != null) {
            tmp.add(head.val);
            head = head.next;
        }
        int n = tmp.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = tmp.get(i);
        return toBst(nums, 0, n);
    }
}