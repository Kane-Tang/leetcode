package leetcode;

import java.util.Stack;

public class StringTransforming {

	public StringTransforming() {
		// TODO Auto-generated constructor stub
	}

	public String transform(String s) {
		int l = s.length();
		StringBuilder res = new StringBuilder();
		Stack<Character> stack = new Stack();
		for(int i=0;i<l;i++) {
			char c = s.charAt(i);
			if(c != '>') {
				//push into stack
				stack.add(c);
			}else {
				//pop
				char cc = stack.pop();
				//withdraw the number
				int count = 0;
				while(cc != '<') {
					count = count*10 + cc- '0';
					cc = stack.pop();
				}
				//withdraw the repeated substring
				char text = stack.pop();
				StringBuilder sub = new StringBuilder();
				while(text != '(') {
					if(text != ')') {
						sub.append(text);
					}
					text = stack.pop();
				}
				for(int j=0;j<count;j++) {
					int len = sub.length();
					while(len > 0) {
						stack.add(sub.charAt(len-1));
						len--;
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			res.append(stack.pop());
		}
		return res.reverse().toString();
	}
	
	public static void main(String[] args) {
		StringTransforming st = new StringTransforming();
		System.out.println(st.transform("a(b(c)<3>d)<2>e"));
	}
}
