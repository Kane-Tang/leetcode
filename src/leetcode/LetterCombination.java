package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LetterCombination {
	public List<String> letterCombinations(String digits) {
		int length = digits.length();
		LinkedList<String> list = new LinkedList<String>();
		if(length == 0) {
			return list;
		}
		String[] ref = new String[] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};//mapping of number and characters
		list.add("");//initialization in case of null pointer
		for(int i=0;i<length;i++) {//the length of digits = lenght of output list
			int a = Character.getNumericValue(digits.charAt(i));//get the responding number
			while(list.peek().length() == i) {//to make sure the process has been finished
				String t = list.remove();
				for(char s:ref[a].toCharArray()) {
					list.add(t+s);
				}
				//System.out.println(list);
				//System.out.println(i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		while(true) {
			Scanner s = new Scanner(System.in);
			LetterCombination lc = new LetterCombination();
			System.out.println(lc.letterCombinations(s.nextLine()));
		}
	}
}
