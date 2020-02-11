package leetcode;

import java.util.Stack;

public class LongestValidParentheses {

	public LongestValidParentheses() {
		// TODO Auto-generated constructor stub
	}

	public int longestValidParentheses(String s) {
		// dp
		int l = s.length();
		int ans = 0;
		int[] dp = new int[l];
		for (int i = 1; i < l; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					if (i >= 2) {
						dp[i] = dp[i - 2] + 2;
					} else {
						dp[i] = 2;
					}
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {// nested
					if (i - dp[i - 1] >= 2) {
						dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
					} else {
						dp[i] = dp[i - 1] + 2;
					}
				}
				ans = Math.max(ans, dp[i]);
			}
		}
		return ans;

//		int l = s.length();
//		Stack<Integer> stack = new Stack();
//		int ans = 0;
//		int[] dp = new int[l];
//		stack.add(-1);
//		for(int i=0;i<l;i++) {
//			char c = s.charAt(i);
//			if(c == '(') {
//				stack.add(i);
//			}else {
//				stack.pop();
//				if(stack.empty()) {
//					stack.add(i);
//				}else {
//					ans = Math.max(ans, i-stack.peek());
//				}
//			}
//		}
//		return ans;
	}
}
