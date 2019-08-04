package leetcode;

public class RemoveNode {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = head;
		int length = 0;
		while(first != null) {
			length++;
			first = first.next;
		}
		length = length - n;
		first = dummy;
		while(length>0) {
			length--;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;//return the pointer of the head of the list
	}

	public static void main(String[] args) {
		RemoveNode rn = new RemoveNode();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		ListNode ans = rn.removeNthFromEnd(n1, 1);
		while(ans != null) {
			System.out.print(ans.val);
			ans = ans.next;
		}
	}
}
