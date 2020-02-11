package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindCommonCharacter {

	public FindCommonCharacter() {
		// TODO Auto-generated constructor stub
	}

	public List<String> commonChars(String[] A) {
		int l = A.length;
		List<String> list = new ArrayList();
		HashMap<Character, Integer> count = new HashMap();
		for(int i=0;i<A[0].length();i++) {
			char c = A[0].charAt(i);
			count.put(c, count.getOrDefault(c, 0)+1);
		}
		for(int i=1;i<l;i++) {
			HashMap<Character, Integer> check = new HashMap();
			String s = A[i];
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				if(count.containsKey(c)) {
					check.put(c, Math.min(count.get(c), check.getOrDefault(c, 0)+1));
				}
			}
			count = check;
		}
		for(char c: count.keySet()) {
			for(int i=0;i<count.get(c);i++) {
				list.add(c+"");
			}
		}
		return list;
	}
}
