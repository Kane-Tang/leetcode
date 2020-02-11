package leetcode;

import java.util.Scanner;

public class Calculator {
	public int calculate(String s) {
		int l = s.length();
		int v1 = 0;
		int v2 = 0;
		char op;
		int res = 0;
		int sign = 1;
		boolean divide = false;
		for(int i=0;i<l;i++) {
			if(s.charAt(i)>='0' && s.charAt(i)<='9') {//is integer
				v2 = v2*10 + s.charAt(i) - '0';//get the number
				//System.out.println(v2);
			}else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
				//operator
				char c = s.charAt(i);
				if(divide) {
					v2 = v1/v2;
					divide = false;
				}
				if(c == '/') {
					divide = true;//wait for the next item
					v1 = sign*v2;
					sign = 1;
				}else if(c == '*') {
					sign = sign*v2;
				}else{
					res += sign*v2;
					if(c == '+') {
						sign = 1;
					}else {
						sign = -1;
					}
				}
				v2 = 0;
			}
		}
		if(v2 > 0) {
			if(divide) {
				v2 = v1/v2;
			}
			res += sign*v2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		Calculator c = new Calculator();
		System.out.println(c.calculate(s));
	}
}
