package leetcode;

public class AddTwoNumbers {

	public AddTwoNumbers() {
		// TODO Auto-generated constructor stub
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//reverse first
		ListNode num1 = null;
		while(l1 != null) {
			ListNode tmp = l1.next;
			l1.next = num1;
			num1 = l1;
			l1 = tmp;
		}
		
		ListNode num2 = null;
		while(l2 != null) {
			ListNode tmp = l2.next;
			l2.next = num2;
			num2 = l2;
			l2 = tmp;
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		int sum = 0;
		int carry = 0;
		while(num1 != null && num2 != null) {
			sum = num1.val+num2.val+carry;
			carry = sum/10;
			sum = sum%10;
			dummy.next = new ListNode(sum);
			num1 = num1.next;
			num2 = num2.next;
			dummy = dummy.next;
		}
		
		while(num1 != null) {
			sum = num1.val+carry;
			carry = sum/10;
			sum = sum%10;
			dummy.next = new ListNode(sum);
			num1 = num1.next;
			dummy = dummy.next;
		}
		
		while(num2 != null) {
			sum = num2.val+carry;
			carry = sum/10;
			sum = sum%10;
			dummy.next = new ListNode(sum);
			num2 = num2.next;
			dummy = dummy.next;
		}
		
		if(carry>0) {
			dummy.next = new ListNode(carry);
		}
		//reverse again
		ListNode num = null;
		ListNode head = p.next;
		while(head != null) {
			ListNode tmp = head.next;
			head.next = num;
			num = head;
			head = tmp;
		}
		return num;
    }
}
