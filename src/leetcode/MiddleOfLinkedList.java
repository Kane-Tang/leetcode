package leetcode;

public class MiddleOfLinkedList {

	public MiddleOfLinkedList() {
		// TODO Auto-generated constructor stub
	}
	public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return slow;
    }
}
