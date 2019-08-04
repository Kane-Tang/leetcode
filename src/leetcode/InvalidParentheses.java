package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InvalidParentheses {
	//simple backtrack
	private Set<String> validExpressions = new HashSet<String>();
	private int minimumRemoved;
	
	private void reset() {
		this.validExpressions.clear();
		this.minimumRemoved = Integer.MAX_VALUE;
	}
	
	private void recurse(String s, int index, int leftcount, int rightcount, StringBuilder expression, int removedCount) {
		if(index == s.length()) {//get to the end
			if(leftcount == rightcount) {//valid
				if(removedCount <= this.minimumRemoved) {//find a better choice
					String possibleAnswer = expression.toString();
					System.out.println(possibleAnswer);
					if(removedCount < this.minimumRemoved) {
						this.validExpressions.clear();
						this.minimumRemoved = removedCount;
					}
					this.validExpressions.add(possibleAnswer);
				}
			}
		}else {
			char currentCharacter = s.charAt(index);
			int length = expression.length();
			if(currentCharacter != '(' && currentCharacter != ')') {
				expression.append(currentCharacter);
				this.recurse(s, index+1, leftcount, rightcount, expression, removedCount);
				expression.deleteCharAt(length);
			}else {
				//System.out.println("current" + currentCharacter);
				this.recurse(s, index+1, leftcount, rightcount, expression, removedCount+1);
				expression.append(currentCharacter);
				//System.out.println(expression);
				if(currentCharacter == '(') {
					this.recurse(s, index+1, leftcount+1, rightcount, expression, removedCount);
				}else if(rightcount<leftcount) {
					this.recurse(s, index+1, leftcount, rightcount+1, expression, removedCount);
				}
				
				expression.deleteCharAt(length);
			}
		}
	}
	
	public List<String> removeInvalidParentheses(String s) {
		this.reset();
		this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
		return new ArrayList(this.validExpressions);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		InvalidParentheses ip = new InvalidParentheses();
		List<String> list = ip.removeInvalidParentheses(s);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
