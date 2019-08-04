package leetcode;

import java.util.PriorityQueue;

public class MergeKList {
	public ListNode mergeKLists(ListNode[] lists) {
		int l = lists.length;
		if(lists == null || l == 0) {
			return null;
		}
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
		for(int i=0;i<l;i++) {
			if(lists[i] != null) {
				pq.add(lists[i]);
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode pointer = dummy;
		
		while(!pq.isEmpty()) {
			ListNode node = pq.poll();
			pointer.next = node;
			if(node != null && node.next != null) {
				pq.add(node.next);
			}
			pointer = pointer.next;
		}
		pointer.next = null;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode l11 = new ListNode(1);
		l11.next = new ListNode(4);
		l11.next.next = new ListNode(5);
		
		ListNode l21 = new ListNode(1);
		l21.next = new ListNode(3);
		l21.next.next = new ListNode(4);
		
		ListNode l31 = new ListNode(2);
		l31.next = new ListNode(6);
		ListNode[] lists = new ListNode[] {l11,l21,l31};
		
		MergeKList mkl = new MergeKList();
		ListNode ans = mkl.mergeKLists(lists);
		while(ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}
