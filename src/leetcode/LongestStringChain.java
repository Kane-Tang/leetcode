package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class LongestStringChain {

	public LongestStringChain() {
		// TODO Auto-generated constructor stub
	}

	public int longestStrChain(String[] words) {
		int l = words.length;
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String w1, String w2) {
				return w1.length() - w2.length();
			}
		});
		
		//dp
		int res = 0;
		HashMap<String, Integer> count = new HashMap();
		for(int i=0;i<l;i++) {
			String cur = words[i];
			if(count.containsKey(cur)) {
				continue;
			}
			count.put(cur, 1);
			for(int j=0;j<cur.length();j++) {
				StringBuilder sb = new StringBuilder(cur);
				sb.deleteCharAt(j);
				String next = sb.toString();
				if(count.containsKey(next) && count.get(next)+1 > count.get(cur)) {
					count.put(cur, count.get(next)+1);
				}
			}
			if(count.get(cur) > res) {
				res = count.get(cur);
			}
		}
		return res;
	}
}
