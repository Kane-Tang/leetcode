package leetcode;

public class DeleteNode {

	public DeleteNode() {
		// TODO Auto-generated constructor stub
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
