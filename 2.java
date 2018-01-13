class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode point = head;
        int sum;
        while (l1 != null || l2 != null){
            sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            carry = sum / 10;
            point.next = new ListNode(sum % 10);
            point = point.next;
        }
        if (carry == 1) point.next = new ListNode(1);
        return head.next;
    }
}