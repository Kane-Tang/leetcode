package leetcode;

public class RemoveElements {

	public RemoveElements() {
		// TODO Auto-generated constructor stub
	}

	public ListNode removeElements(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode point = dummy;
		while(point != null) {
			if(point.next!=null && point.next.val == val) {
				point.next = point.next.next;
			}else {
				point = point.next;
			}
		}
		return dummy.next;
	}
}
