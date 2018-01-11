class Solution
{
	public ListNode DeleteDuplicates(ListNode head)
	{
		if (head == null || head.next == null) return head;
		ListNode foo = new ListNode(0);
		foo.next = head;
		ListNode point = foo;
		int last = head.val;
		bool flag = false;
		while (head.next != null)
		{
			if (head.next.val == last)
			{
				flag = true; head = head.next;
			}
			else
			{
				if (flag)
				{
					point.next = head.next;
					last = head.next.val;
					head = head.next;
					flag = false;
				}
				else
				{
					point = point.next;
					last = head.next.val;
					head = head.next;
					flag = false;
				}
			}
		}
		if (flag) point = head.next;
		else point = point.next;
		return foo.next;
	}
}