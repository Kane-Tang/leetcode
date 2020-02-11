package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public EvaluateReversePolishNotation() {
		// TODO Auto-generated constructor stub
	}

	public int evalRPN(String[] tokens) {
		int l = tokens.length;
		//use stack
		Stack<Integer> stack = new Stack();
		for(int i=0;i<l;i++) {
			String s = tokens[i];
			if(s.charAt(s.length()-1) >= '0' && s.charAt(s.length()-1) <= '9') {// is integer
				stack.add(Integer.parseInt(s));
			}else {
				int o2 = stack.pop();
				int o1 = stack.pop();
                System.out.println(o1+" "+o2);
				switch(s) {
				case "+":
					stack.add(o1+o2);
					break;
				case "-":
					stack.add(o1-o2);
					break;
				case "*":
					stack.add(o1*o2);
					break;
				case "/":
					stack.add(o1/o2);
					break;
				default:
						break;
				}
			}
		}
		return stack.pop();
	}

}
