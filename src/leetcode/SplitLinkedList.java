package leetcode;

import java.util.LinkedList;

public class SplitLinkedList {

	public SplitLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
//		LinkedList<ListNode> list = new LinkedList();
//		while (root != null) {
//			list.add(root);
//			root = root.next;
//		}
//		int n = list.size();
//		int group = n / k;
//		int rem = n % k;
//		LinkedList<ListNode> ans = new LinkedList();
//		int count = 0;
//		ListNode tmp = null;
//		int num = 0;
//		for (int i = 0; i < list.size(); i++) {
//			if (count != 0 && count < ((num <= rem) ? group + 1 : group)) {
//				tmp.next = list.get(i);
//				tmp = tmp.next;
//				// ans.get(ans.size()-1).next = list.get(i);
//				count++;
//			} else {
//				if (tmp != null) {
//					tmp.next = null;
//				}
//				ans.add(list.get(i));
//				tmp = list.get(i);
//				count = 1;
//				num++;
//			}
//		}
//		while (ans.size() < k) {
//			ans.add(null);
//		}
//		ListNode[] res = new ListNode[k];
//		for (int i = 0; i < k; i++) {
//			res[i] = ans.get(i);
//		}
//		return res;
	}
}
