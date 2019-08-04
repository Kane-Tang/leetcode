package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode node = null;
		ListNode a = headA;
		ListNode b = headB;
		//two pointer, find from the beginning, if one gets to the end, then points at the other list's head
		while(a!=null || b!=null) {
			if(a == b) {
				return a;
			}
			
			if(a == null) {
				a = headB;
			}else {
				a = a.next;
			}
			
			if(b == null) {
				b = headA;
			}else {
				b = b.next;
			}
		}
		return node;
	}
}
