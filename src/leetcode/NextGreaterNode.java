package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNode {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public NextGreaterNode() {
		// TODO Auto-generated constructor stub
	}

	public int[] nextLargerNodes(ListNode head) {
		//stack
		ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
		
//		//dp
//		//first transfer to array
//		List<Integer> l = new ArrayList();
//		while(head != null) {
//			l.add(head.val);
//			head = head.next;
//		}
//		int[] array = new int[l.size()];
//		for(int i=0;i<l.size();i++) {
//			array[i] = l.get(i);
//		}
//		
//		int[] dp = new int[array.length];
//		for(int i=1;i<array.length;i++) {
//			if(array[i]>array[0]) {
//				dp[0] = i;
//				break;
//			}
//		}
//		
//		for(int i=1;i<array.length;i++) {
//			if(dp[i-1] == 0) {
//				for(int j=i+1;j<array.length;j++) {
//					if(array[j] > array[i]) {
//						dp[i] = j;
//					}
//				}
//			}else {
//				if(dp[i-1] > i) {
//					dp[i] = dp[i-1];
//				}else {
//					for(int j=i+1;j<array.length;j++) {
//						if(array[j] > array[i]) {
//							dp[i] = j;
//						}
//					}
//				}
//			}
//		}
//		int[] ans = new int[dp.length];
//		for(int i=0;i<dp.length;i++) {
//			if(dp[i]==0) {
//				ans[i] = 0;
//			}else {
//				ans[i] = array[dp[i]];
//			}
//		}
//		return ans;
		
		//brute force
//		List<Integer> list = new ArrayList();
//		while(head != null) {
//			ListNode p = head.next;
//			if(p == null) {
//				list.add(0);
//				break;
//			}
//			while(p != null && p.val <= head.val) {
//				p = p.next;
//			}
//			if(p == null) {
//				list.add(0);
//			}else {
//				list.add(p.val);
//			}
//			head = head.next;
//		}
//		int[] ans = new int[list.size()];
//		for(int i=0;i<list.size();i++) {
//			ans[i] = list.get(i);
//		}
//		return ans;
	}
}
