package leetcode;

public class RemoveDuplicated {

	public RemoveDuplicated() {
		// TODO Auto-generated constructor stub
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode pointer = dummy;
		while(pointer.next != null) {
			if(pointer.val == pointer.next.val) {
				pointer.next = pointer.next.next;
			}else {
				pointer = pointer.next;
			}
		}
		return dummy.next;
	}
}
