package leetcode;

public class MyLinkedList {

	class ListNode{
		private int val;
		private ListNode next;
		private ListNode prev;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	//private variable:
	ListNode head;
	ListNode tail;
	int size = 0;
	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = new ListNode(0);
		tail = new ListNode(0);
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		int ind = 0;
		if(index < 0 || index >= size) {
			return -1;
		}
		ListNode p = head;
		for(int i=0;i<=index;i++) {
			p = p.next;
		}
		if(p != null)
			return p.val;
		else
			return -1;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		ListNode node = new ListNode(val);
		ListNode tmp = head.next;
		head.next = node;
		node.prev = head;
		node.next = tmp;
		tmp.prev = node;
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		ListNode node = new ListNode(val);
		ListNode tmp = tail.prev;
		node.next = tail;
		node.prev = tmp;
		tmp.next = node;
		tail.prev = node;
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		ListNode p = head;
		if(index < 0) {
			addAtHead(val);
		}
		if(index > size) {
			return;
		}
		for(int i=0;i<index;i++) {
			if(p != null)
				p = p.next;
			else
				return;
		}
		ListNode node = new ListNode(val);
		ListNode tmp = p.next;
		p.next = node;
		node.prev = p;
		node.next = tmp;
		tmp.prev = node;
		size++;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		ListNode p = head;
		if(index >= size || index < 0) {
			return;
		}
		for(int i=0;i<=index;i++) {
			p = p.next;
		}
		ListNode tmp1 = p.prev;
		ListNode tmp2 = p.next;
		tmp1.next = tmp2;
		tmp2.prev = tmp1;
		size--;
	}

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
