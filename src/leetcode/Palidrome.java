package leetcode;

import java.util.Scanner;

public class Palidrome {
	public boolean isPalindrome(String s) {
		int length = s.length();
		s = s.toLowerCase();
		char[] array = new char[length];
		int index = 0;
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) >= 97 && s.charAt(i) <= 122 || s.charAt(i) >= 48 && s.charAt(i) <= 57) {
				array[index] = s.charAt(i);
				index++;
			}
		}
		String ans = new String(array, 0, index);
		length = ans.length();
		for (int i = 0; i < length; i++) {
			if (ans.charAt(i) != ans.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public int countSubstrings(String s) {
		if(s.length()==0) {
			return 0;
		}
		if(s.length()==1) {
			return 1;
		}
		String s1 = s.substring(1,s.length());
		String s2 = s.substring(0,s.length()-1);
		String newString = s.substring(1, s.length()-1);
		if(isPalindrome(s)) {
			return Math.max(countSubstrings(s1)+1,countSubstrings(s2)+1)+1;
		}else {
			return Math.max(countSubstrings(s1)+1,countSubstrings(s2)+1);
		}
	}

	public static void main(String[] args) {
		Palidrome p = new Palidrome();
		Scanner s = new Scanner(System.in);
		System.out.println(p.countSubstrings(s.nextLine()));
	}
}
