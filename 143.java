// three step: 1. find the middle node 2. cut and reverse the latter node link 3. merge two list node
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode p = null, p1 = head2.next;
        head2.next = null;
        while (p1 != null){
            p = p1.next;
            p1.next = head2;
            head2 = p1;
            p1 = p;
        }
        for (p = head, p1 = head2; p1 != null;){
            ListNode t = p.next;
            p.next = p1;
            p1 = p1.next;
            p = p.next.next = t;
            
        }
    }
}