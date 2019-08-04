package leetcode;

public class MergeList {
	public ListNode MergeTwoList(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode first = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				first.next = l1;
				l1 = l1.next;
			}
			else {
				first.next = l2;
				l2 = l2.next;
			}
			first = first.next;
		}
		
		if(l1 == null) {
			first.next = l2;
		}else {
			first.next = l1;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		MergeList ml = new MergeList();
		ListNode l11 = new ListNode(1);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(5);
		l11.next = l12;
		l12.next = l13;
		ListNode l21 = new ListNode(2);
		ListNode l22 = new ListNode(3);
		ListNode l23 = new ListNode(6);
		l21.next = l22;
		l22.next = l23;
		ListNode ans = ml.MergeTwoList(l11, l21);
		while(ans!=null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}
