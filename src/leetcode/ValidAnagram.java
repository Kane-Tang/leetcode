package leetcode;

import java.util.HashMap;

public class ValidAnagram {

	public ValidAnagram() {
		// TODO Auto-generated constructor stub
	}

	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		HashMap<Character, Integer> count = new HashMap();
		for(int i=0;i<s.length();i++) {
			count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
		}
		
		for(int i=0;i<t.length();i++) {
			if(!count.containsKey(t.charAt(i))||count.get(t.charAt(i))==0) {
				return false;
			}else {
				count.put(t.charAt(i), count.get(t.charAt(i))-1);
			}
		}
		return true;
	}

}
