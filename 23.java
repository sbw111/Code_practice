class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);

        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length + 1, new Comparator<ListNode>() {
            public int compare(ListNode p1, ListNode p2) {
                if (p1.val < p2.val) return -1;
                else return 1;
            }
        });
        ListNode next = dummy;
        for (ListNode l : lists) if (l != null) q.add(l);
        while (!q.isEmpty()) {
            next.next = q.poll();
            next = next.next;
            if (next.next != null) q.add(next.next);
        }
        return dummy.next;
    }
}