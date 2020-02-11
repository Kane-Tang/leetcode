package leetcode;

import java.util.LinkedList;

public class LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public LinkedListCycle() {
		// TODO Auto-generated constructor stub
	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				while(slow != head) {
					head = head.next;
					slow = slow.next;
				}
				return head;
			}else {
				continue;
			}
		}
		return null;
		
		
//		LinkedList<ListNode> list = new LinkedList();
//		while(head != null) {
//			if(!list.contains(head)) {
//				list.add(head);
//				head = head.next;
//			}else {
//				return head;
//			}
//		}
//		return null;
	}
}
