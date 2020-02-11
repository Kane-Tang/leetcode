package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class WordLadder {
	// two end bfs
	public int ladderL(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
		if(!wordList.contains(endWord))
			return 0;
		int len = 1;
		int strLen = beginWord.length();
		HashSet<String> visited = new HashSet<String>();

		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
		}

		return 0;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int l = wordList.size();
		if (l == 0) {
			return 0;
		}
		if (!wordList.contains(endWord)) {
			return 0;
		}
		// backtrack recursion
		HashMap<String, List<String>> hm = new HashMap();
		for (int i = 0; i < l; i++) {
			String s = wordList.get(i);
			List<String> list = new ArrayList();
			for (String tmp : wordList) {
				int size = s.length();
				int count = 0;
				for (int j = 0; j < size; j++) {
					char c1 = s.charAt(j);
					char c2 = tmp.charAt(j);
					if (c1 == c2) {
						continue;
					} else {
						count++;
					}
				}
				if (count == 1) {
					list.add(tmp);
				}
			}
			hm.put(s, list);
		}

		List<String> list = new ArrayList();
		for (String tmp : wordList) {
			int size = tmp.length();
			int count = 0;
			for (int j = 0; j < size; j++) {
				char c1 = beginWord.charAt(j);
				char c2 = tmp.charAt(j);
				if (c1 == c2) {
					continue;
				} else {
					count++;
				}
			}
			if (count == 1) {
				list.add(tmp);
			}
		}
		hm.put(beginWord, list);
		HashMap<String, Boolean> visit = new HashMap();
		visit.put(beginWord, true);
		// boolean flag = false;
		// bfs
		// search the end word level by level
		// find the one on the highest lvl
		Queue<Pair<String, Integer>> queue = new LinkedList();
		queue.add(new Pair(beginWord, 1));
		int ans = findAns(queue, endWord, hm, visit);
		return ans;
	}

	public int findAns(Queue<Pair<String, Integer>> queue, String endWord, HashMap<String, List<String>> hm,
			HashMap<String, Boolean> visit) {
		while (!queue.isEmpty()) {
			Pair<String, Integer> pair = queue.poll();
			String word = pair.getKey();
			int val = pair.getValue();
			System.out.print(word + " " + val);
			System.out.println();
			List<String> list = hm.get(word);
			for (String s : list) {
				if (s.equals(endWord)) {
					// System.out.println(val);
					return val + 1;
				}

				if (!visit.containsKey(s)) {
					visit.put(s, true);
					queue.add(new Pair(s, val + 1));
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> list = new ArrayList();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(beginWord, endWord, list));
	}
}
