package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
	public List<List<String>> groupAnagrams(String[] strs) {
		int n = strs.length;
		Map<String,List<String>> map = new HashMap();
		for(String s: strs) {
			char[] tmp = s.toCharArray();
			Arrays.sort(tmp);
			String key = String.valueOf(tmp);
			//System.out.println(key);
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList());
			}
			map.get(key).add(s);
		}
		List<List<String>> ans = new ArrayList(map.values()); 
		return ans;
	}
	
	public static void main(String[] args) {
		GroupAnagram ga = new GroupAnagram();
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> ans = ga.groupAnagrams(strs);
		System.out.println(ans);
	}
}
