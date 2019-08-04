package leetcode;

import java.util.Scanner;

public class SubStr {
	public int strStr(String haystack, String needle) {
		int length = haystack.length();
		int l = needle.length();
		if(l == 0) {
			return 0;
		}
		if(l>length) {
			return -1;
		}
		for(int i=0;i<length-l+1;i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				int j = 1;
				for(j=1;j<l;j++) {
					if(needle.charAt(j) == haystack.charAt(i+j)) {
						continue;
					}
					else {
						break;
					}
				}
				if(j == l) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SubStr ss = new SubStr();
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] s = input.split(" ");
		String haystack = s[0];
		String needle = s[1];
		System.out.println(ss.strStr(haystack, needle));
		
	}
}
