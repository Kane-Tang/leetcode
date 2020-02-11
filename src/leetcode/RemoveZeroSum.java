package leetcode;

public class RemoveZeroSum {

	public RemoveZeroSum() {
		// TODO Auto-generated constructor stub
	}

	public ListNode removeZeroSumSublists(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode p = head;
		int sum = 0;
		while(p != null) {
			sum += p.val;
			if(sum == 0) {
				//cut off the previous part
				return removeZeroSumSublists(p.next);
			}else {
				p = p.next;
			}
		}
		
		//deal with the substring
		head.next = removeZeroSumSublists(head.next);
		return head;
	}
}
