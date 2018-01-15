class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode small = node1;
        ListNode big = node2;
        while (head != null){
            if (head.val < x){
                small = small.next = head;
            }
            else {
                big = big.next = head;
            }
            head = head.next;
        }
        small.next = node2.next;
        big.next = null;
        return node1.next;
    }
}