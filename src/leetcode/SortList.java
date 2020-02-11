package leetcode;

public class SortList {

	public SortList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode sortList(ListNode head) {
		//Sort a linked list in O(n log n) time using constant space complexity.
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode pre = null;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast!=null && fast.next!=null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode h1 = sortList(head);
		ListNode h2 = sortList(slow);
		return merge(h1,h2);
	}
	
	public ListNode merge(ListNode h1, ListNode h2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(h1!=null && h2!=null) {
			if (h1.val < h2.val) {
				p.next = h1;
				h1 = h1.next;
			} else {
				p.next = h2;
				h2 = h2.next;
			}
			p = p.next;
		}
		
		if(h1!=null) {
			p.next = h1;
		}
		if(h2!=null) {
			p.next = h2;
		}
		return dummy.next;
	}
}
