package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
//		int length = wordDict.size();
//		if(length==0&&s=="") {
//			return true;
//		}
//		if(length == 0 && s!="") {
//			return false;
//		}
//		if(s=="" && length!=0) {
//			return false;
//		}
//		String check = s;
//		int count = 0;
//		String vacant = s;
//		int[] visited = new int[s.length()];
//		while (vacant.length() != 0) {
//			int i=0;
//			int l = wordDict.size();
//			for (i = 0; i < l; i++) {
//				String tmp = wordDict.get(i);
//				if (s.contains(tmp)) {
//					s = s.replace(tmp, " ");
//					vacant = vacant.replace(tmp, "");
//					System.out.println(s);
//					break;
//				}
//				
//				if(i==l-1 && vacant.length()!=0) {
//					s = check;
//					vacant = check;
//					String add = wordDict.remove(0);
//					wordDict.add(add);
//					if(count == length-1) {
//						return false;
//					}
//					count++;
//				}
//			}
//		}
//		return true;
		Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
	}
	
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		List<String> list = new ArrayList();
		list.add("cat");
		list.add("and");
		list.add("dog");
		//list.add("rs");
		String s = "catandog";
		System.out.println(wb.wordBreak(s, list));;
	}
}
