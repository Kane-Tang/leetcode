package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome {

	public LongestPalindrome() {
		// TODO Auto-generated constructor stub
	}

	public int longestPalindrome(String s) {
		int l = s.length();
		HashMap<Character, Integer> dict = new HashMap();
		for(int i=0;i<l;i++) {
			char c = s.charAt(i);
			dict.put(c, dict.getOrDefault(c, 0)+1);
		}
		List<Map.Entry<Character, Integer>> list = new ArrayList(dict.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		int maxOdd = 0;
		int ans = 0;
		for(Map.Entry<Character, Integer> item: list) {
			int v = item.getValue();
			if(v%2 == 0) {
				ans += v;
				continue;
			}else {
				ans += v-1;
				if(v > maxOdd) {
					maxOdd = v;
				}
			}
		}
		if(maxOdd != 0)
			ans += 1;
		return ans;
	}
}
