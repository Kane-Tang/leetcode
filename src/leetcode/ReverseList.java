package leetcode;

public class ReverseList {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==1) {
			int pos = 1;
			ListNode first = head;
			ListNode ans = null;
			while(pos>=m&&pos<=n) {
				ListNode tmp = ans;
				ans = first;
				first = first.next;
				ans.next = tmp;
				pos++;
			}
			ListNode dummy = new ListNode(0);
			dummy.next = ans;
			int num = n-m;
			while(num>0) {
				ans = ans.next;
				num--;
			}
			ans.next = first;
			return dummy.next;
			
		}
		else {
			int pos = 1;
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			ListNode first = head;
			while(pos<m) {
				first = first.next;
				pos++;
			}
			ListNode ans = null;
			while(pos>=m&&pos<=n) {
				ListNode tmp = ans;
				ans = first;
				first = first.next;
				ans.next = tmp;
				pos++;
			}
			pos = 1;
			while(pos<m-1) {
				head = head.next;
				pos++;
			}
			head.next = ans;
			int num = n-m;
			while(num>=0) {
				head = head.next;
				num--;
			}
			head.next = first;
			return dummy.next;
		}
		
	}
	
	public static void main(String[] args) {
		ReverseList rl = new ReverseList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		ListNode output = rl.reverseBetween(n1, 1, 5);
		while(output!=null) {
			System.out.println(output.val);
			output = output.next;
		}
	}
}
