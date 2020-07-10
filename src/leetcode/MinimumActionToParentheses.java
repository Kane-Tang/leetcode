package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumActionToParentheses {

	public MinimumActionToParentheses() {
		// TODO Auto-generated constructor stub
	}

	public String minRemoveToMakeValid(String s) {
		int l = s.length();
		Set<Integer> set = new HashSet();
		Stack<Integer> stack = new Stack();
		for(int i=0;i<l;i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(i);
			}else if(c == ')') {
				if(stack.isEmpty()) {
					set.add(i);
				}else {
					stack.pop();
				}
			}
		}
		
		while(!stack.isEmpty()) {
			set.add(stack.pop());
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<l;i++) {
			if(set.contains(i)) {
				continue;
			}else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
