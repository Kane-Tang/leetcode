package leetcode;

import java.util.Scanner;

public class KMP {
	//Knuth-Morris-Pratt
	//build next[] array, for each next[i], it means before the character i, there are two sane prefix and suffix whose length is next[i]
	//then try to find the new position according to next[]
	
	//firstly, build array next[]
	//according to next[0] to next[j], try to find next[j+1]
	//for the first j+1 characters, 
	//if p[k]==p[j], then next[j+1] = next[j]+1 = k+1
	public void findNext(String p, int[] next) {
		//go for p[j] and p[k]
		int l = p.length();
		next[0] = -1;
		int k = -1;//k represents the index of prefix
		int j = 0;//j represents the index of suffix
		while(j < l-1) {
			if(k==-1 || p.charAt(k)==p.charAt(j)) {
				k++;
				j++;
				if(p.charAt(k)!=p.charAt(j)) {
					next[j] = k;
				}else {
					next[j] = next[k];
				}
			}else {
				k = next[k];
			}
		}
	}
	
	public int findkmp(String s, String p) {
		int[] next = new int[p.length()];
		findNext(p, next);
		int i = 0;//the index of s
		int j = 0;//the index of p
		while(i<s.length() && j<p.length()) {
			if(j==-1 || s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if(j == p.length()) {
			return i-j;
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		String s = in.nextLine();
		String p = in.nextLine();
		KMP kmp = new KMP();
		System.out.println(kmp.findkmp(s, p));;
	}
}
