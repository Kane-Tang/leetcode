package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> map = new HashMap();
		Map<Character, Integer> degree = new HashMap();
		String res = "";
		if(words==null || words.length==0) return res;
		for(String word: words) {//checj how many characters have appeared
			for(char c: word.toCharArray()) {
				degree.put(c, 0);
			}
		}
		
		//traverse all the words
		for(int i=0;i<words.length-1;i++) {
			String cur = words[i];
			String next = words[i+1];
			int length = Math.min(cur.length(), next.length());
			for(int j=0;j<length;j++) {
				char c1 = cur.charAt(j);
				char c2 = next.charAt(j);
				if(c1 != c2) {
					Set<Character> set = new HashSet();
					if(map.containsKey(c1)) {
						set = map.get(c1);
					}
					if(!set.contains(c2)) {
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, degree.get(c2)+1);//the higher the value is, the lower the priority is
					}
					break;
				}
			}
		}
		
		//find the beginning point
		Queue<Character> q = new LinkedList();
		for(char c: degree.keySet()) {
			if(degree.get(c) == 0) {
				q.add(c);
			}
		}
		
		//bfs search
		while(!q.isEmpty()) {
			char c = q.remove();
			res += c;
			if(map.containsKey(c)) {
				for(char c2: map.get(c)) {
					degree.put(c2, degree.get(c2)-1);
					if(degree.get(c2) == 0) {
						q.add(c2);
					}
				}
			}
		}
		
		if(res.length() != degree.size()) {
			return "";
		}
		return res;
	}

	public boolean isAlienSorted(String[] words, String order) {
		int[] index = new int[26];
		for (int i = 0; i < order.length(); ++i)
			index[order.charAt(i) - 'a'] = i;

		search: for (int i = 0; i < words.length - 1; ++i) {
			String word1 = words[i];
			String word2 = words[i + 1];
			// check one by one
			// Find the first difference word1[k] != word2[k].
			for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
				if (word1.charAt(k) != word2.charAt(k)) {
					// If they compare badly, it's not sorted.
					if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
						return false;
					continue search;
				}
			}

			// If we didn't find a first difference, the
			// words are like ("app", "apple").
			if (word1.length() > word2.length())
				return false;
		}

		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(9.0/5);
		double a = 9;
		double b = 5;
		System.out.println(a/b);
	}
}
