package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
	public List<Integer> findAnagrams(String s, String p) {
//		int l1 = s.length();
//		int l2 = p.length();
//		List<Integer> list = new ArrayList();
//		for(int i=0;i<l1;i++) {
//			
//		}
//		return list;

		List<Integer> res = new ArrayList<>();
		char[] sArr = s.toCharArray(), pArr = p.toCharArray();
		if (sArr.length < pArr.length)
			return res;

		Map<Character, Integer> map = new HashMap<>(), cMap = new HashMap<>();
		for (char c : pArr) {
			map.put(c, map.get(c) != null ? map.get(c) + 1 : 1);
		}
		cMap.putAll(map);

		int len = sArr.length;
		int begin = 0;
		int end = 0;
		int count = map.size();
		while (end < len) {
			if (cMap.get(sArr[end]) == null) {// current letter not in the string p, move the window
				//System.out.println(sArr[end]);
				end++;
				begin = end;
				count = cMap.size();
				//System.out.println(count);
				cMap.putAll(map);
			} else if (cMap.get(sArr[end]) == 0) {// has been used up
				System.out.println(sArr[end]);
				System.out.println(sArr[begin]);
				while (sArr[end] != sArr[begin]) {
					if (cMap.get(sArr[begin]) == 0)
						count++;
					cMap.put(sArr[begin], cMap.get(sArr[begin]) + 1);
					begin++;
				}
				count++;
				cMap.put(sArr[begin], cMap.get(sArr[begin]) + 1);
				begin++;
			} else {
				//System.out.println(sArr[end]);
				//System.out.println(end);
				cMap.put(sArr[end], cMap.get(sArr[end]) - 1);//use one letter
				if (cMap.get(sArr[end]) == 0) {
					//System.out.println(count);
					count--;
				}
					
				if (count == 0) {//find a anagram
					res.add(begin);
					if (cMap.get(sArr[begin]) == 0)
						count++;
					cMap.put(sArr[begin], cMap.get(sArr[begin]) + 1);
					begin++;
				}
				end++;
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		Anagram a = new Anagram();
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> list = a.findAnagrams(s, p);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
