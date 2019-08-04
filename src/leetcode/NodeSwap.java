package leetcode;

public class NodeSwap {
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		while(head != null && head.next != null) {
			ListNode tmp = head.next;
			head.next = tmp.next;
			tmp.next = head;
			first.next = tmp;
			first = head;
			head = head.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		NodeSwap ns = new NodeSwap();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode ans = ns.swapPairs(n1);
		while(ans!=null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}
