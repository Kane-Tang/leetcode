package leetcode;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CalculatorTwo {
	public int calculate(String s) {
		//use stack
		Stack<Integer> stack = new Stack();
		int res = 0;
		int sign = 1;
		int num = 0;
		int l = s.length();
		stack.push(1);
		for(int i=0;i<l;i++) {
			char c = s.charAt(i);
			if(c == '+') {
				res += sign*num;
				num = 0;
				sign = 1;
			}else if(c == '-') {
				res += sign*num;
				num = 0;
				sign = -1;
			}else if(c == '(') {
				//push
				//use stack to keep the tmp
				//restart for the new module
				stack.push(res);
				stack.push(sign);
				sign = 1;
				res = 0;
			}else if(c == ')') {
				res += sign*num;
				num = 0;
				res *= stack.pop();
				res += stack.pop();
			}
			
			if(c >= '0' && c <= '9') {
				num = num*10 + c - '0';
			}
		}
		if(num != 0) {
			res += sign*num;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		CalculatorTwo c = new CalculatorTwo();
		System.out.println(c.calculate(s));
	}
}
