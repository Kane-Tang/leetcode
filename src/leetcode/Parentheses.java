package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parentheses {
	public List<String> generateParentheses(int n){
		List<String> ans = new ArrayList();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}
	
	public void backtrack(List<String> ans, String current, int open, int close, int max) {
		if(current.length() == max*2) {
			ans.add(current);
		}
		else {
			if(open<max) {
				backtrack(ans, current+"(", open+1, close, max);
			}
			if(close<open) {
				backtrack(ans, current+")", open, close+1, max);
			}
			//System.out.println(current);
		}
	}
	
	public static void main(String[] args) {
		Parentheses p = new Parentheses();
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		List ans = p.generateParentheses(n);
		System.out.println(ans);
	}
}
