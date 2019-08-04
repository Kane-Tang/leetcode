package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WindowSubstring {
	public String minWindow(String s, String t) {
		//slide window with two pointers
		int sl = s.length();
		int tl = t.length();
		char[] dict = new char[256];
		char[] match = new char[256];
		
		int left = 0;
		int right = 0;
		int len = Integer.MAX_VALUE;
		for(int i=0;i<tl;i++) {
			dict[t.charAt(i)]++;
		}
		int count = 0;
		int begin = 0;
		for(int end=0;end<sl;end++) {
			char cur = s.charAt(end);
			if(dict[cur] == 0) {
				continue;
			}
			
			match[cur]++;
			if(match[cur] <= dict[cur]) {
				count++;
			}
			if(count == tl) {
				//shorten the match string in order to find a optimize result
				char c = s.charAt(begin);
				while(match[c] > dict[c] || dict[c] == 0) {
					if(match[c] > dict[c]) {
						match[c]--;
					}
					begin++;
					c = s.charAt(begin);
				}
				
				if(len > end - begin + 1) {
					len = end-begin+1;
					left = begin;
					right = end;
				}
			}
		}
		if(count != tl) {
			return "";
		}
		return s.substring(left,right+1);
    }
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		WindowSubstring ws = new WindowSubstring();
		System.out.println(ws.minWindow(s, t));
	}
}
