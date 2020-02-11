package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniqueCharacter {
	public int firstUniqChar(String s) {
		int l = s.length();
		LinkedHashMap<Character,Integer> hm = new LinkedHashMap();
		for(int i=0;i<l;i++) {
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
		}
		int count = 0;
		Set<Character> keys = hm.keySet();
		for(Character key: keys) {
			if(hm.get(key)==1) {
				return s.indexOf(key);
			}
		}
		return -1;
	}
}
