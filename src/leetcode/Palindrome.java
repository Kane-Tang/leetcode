package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Palindrome {
	public boolean isPalindrome(ListNode head) {
//		LinkedList<Integer> list = new LinkedList();
//		while(head != null) {
//			list.add(head.val);
//			head = head.next;
//		}
//		int l = list.size();
//		for(int i=0;i<l;i++) {
//			if(list.get(i) != list.get(l-1-i)) {
//				return false;
//			} 
//		}
//		return true;
		if (head == null) {
            return true; // LeetCode expects 'true' here
        }

        // Reverse 2nd half of list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // for lists with odd # of Nodes
            slow = slow.next;
        }
        ListNode slowCenter = reverseList(slow);

        // compare 1st half of list to 2nd half
        ListNode slowFront = head;
        while (slowCenter != null) {
            if (slowCenter.val != slowFront.val) {
                return false;
            }
            slowFront = slowFront.next;
            slowCenter = slowCenter.next;
        }
        return true;
	}
	
	private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev; // changes arrow direction
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
