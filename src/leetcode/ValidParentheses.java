package leetcode;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		int length = s.length();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < length; i++) {
			char tmp = s.charAt(i);
			if (tmp == '(' || tmp == '[' || tmp == '{') {
				stack.push(tmp);
			} else if (tmp == ')') {
				if (!stack.isEmpty()) {
					char match = stack.pop();
					if (match == '(') {
						continue;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else if (tmp == ']') {
				if (!stack.isEmpty()) {
					char match = stack.pop();
					if (match == '[') {
						continue;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else if (tmp == '}') {
				if (!stack.isEmpty()) {
					char match = stack.pop();
					if (match == '{') {
						continue;
					} else {
						return false;
					}
				}
				else {
					return false;
				}
			} else {
				continue;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid(s));
	}
}
