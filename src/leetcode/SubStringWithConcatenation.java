package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenation {

	public SubStringWithConcatenation() {
		// TODO Auto-generated constructor stub
	}

	public List<Integer> findSubstring(String s, String[] words) {
		Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        List<Integer> indexes = new ArrayList<>();
        if(words.length == 0) {
        	return indexes;
        }
        int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
//		List<Integer> res = new ArrayList();
//		if(words.length==0) {
//			return res;
//		}
//		boolean[] visit = new boolean[words.length];
//		for(int i=0;i<s.length();i++) {
////			HashMap<String, Integer> count = new HashMap();
////			for(String word: words) {
////				count.put(word, count.getOrDefault(word, 0)+1);
////			}
////			if(findAns(s, words, count, i)) {
////				res.add(i);
////			}
//			if(findAns(s, words, visit, i)) {
//				res.add(i);
//			}
//		}
//		return res;
	}
	
	public boolean findAns(String s, String[] words, boolean[] visit, int index) {
		for(int i=0;i<visit.length;i++) {
			visit[i] = false;
		}
		//search from index
		dfs(s, words, visit, index);
		for(int i=0;i<visit.length;i++) {
			if(visit[i] == false) {
				return false;
			}
		}
		return true;
	}
	public void dfs(String s, String[] words, boolean[] visit, int index) {
		if(index >= s.length()) {
			return;
		}
		for(int i=0;i<words.length;i++) {
			String word = words[i];
			int l = word.length();
			if(!visit[i]) {
				if(index+l<=s.length() && s.substring(index, index+l).equals(word)) {
					visit[i] = true;
					dfs(s, words, visit, index+l);
					break;
				}
			}
		}
	}
	
//	public boolean findAns(String s, String[] words, HashMap<String, Integer> count, int index) {
//		//search from index
//		dfs(s, words, count, index);
//		for(String key: count.keySet()) {
//			if(count.get(key) > 0) {
//				return false;
//			}
//		}
//		return true;
//	}
//	public void dfs(String s, String[] words, HashMap<String, Integer> count, int index) {
//		if(index >= s.length()) {
//			return;
//		}
//		for(int i=0;i<words.length;i++) {
//			String word = words[i];
//			int l = word.length();
//			if(count.containsKey(word) && count.get(word)>0) {
//				if(index+l<=s.length() && s.substring(index, index+l).equals(word)) {
//					count.put(word, count.get(word)-1);
//					dfs(s, words, count, index+l);
//				}
//			}
//		}
//	}
}
