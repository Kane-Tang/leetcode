package leetcode;

public class ReverseTotalList {
	public ListNode reverseList(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode first = head;
		ListNode ans = null;
		while(first!=null) {
			ListNode tmp = ans;
			ans = first;
			first = first.next;
			ans.next = tmp;
		}
		dummy.next = ans;
		return dummy.next;
	}
}
