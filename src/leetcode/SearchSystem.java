package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SearchSystem {
	/*
	private HashMap<String, Integer> map = new HashMap();
	private String cur_sen = "";

	public SearchSystem(String[] sentences, int[] times) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < times.length; i++) {
			map.put(sentences[i], times[i]);
		}
	}

	public List<String> input(char c) {
		List<String> res = new ArrayList<>();
		if (c == '#') {
			map.put(cur_sen, map.getOrDefault(cur_sen, 0) + 1);
			cur_sen = "";
		} else {
			List<SearchNode> list = new ArrayList<>();
			cur_sen += c;
			for (String key : map.keySet())
				if (key.indexOf(cur_sen) == 0) {
					list.add(new SearchNode(key, map.get(key)));
				}
			Collections.sort(list, (a, b) -> a.times == b.times ? a.sen.compareTo(b.sen) : b.times - a.times);
			for (int i = 0; i < Math.min(3, list.size()); i++)
				res.add(list.get(i).sen);
		}
		return res;
	}
	*/
	//using trie
	private SearchTrie root;
	private String cur_sent = "";

}
