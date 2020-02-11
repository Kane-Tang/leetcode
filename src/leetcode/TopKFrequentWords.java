package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> hm = new HashMap();
		int l = words.length;
		for(int i=0;i<l;i++) {
			hm.put(words[i], hm.getOrDefault(words[i], 0)+1);
		}
		
		List<Map.Entry<String,Integer>> list = new ArrayList();
		list.addAll(hm.entrySet());
		//hash sort!!!!!!!!!!!!!!!!!!!!!!
		//use api: collections.sort(list, new comparator())
		//need override depending on the sorting requirements
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> ele1, Map.Entry<String, Integer> ele2) {
				if(ele1.getValue()==ele2.getValue()) {
					return ele1.getKey().compareTo(ele2.getKey());
				}
				return ele2.getValue() - ele1.getValue();
			}
		});
		Iterator<Map.Entry<String, Integer>> iterator = list.iterator();
		int count = 0;
		LinkedList<String> ans = new LinkedList();
		while(count<k) {
			ans.add(iterator.next().getKey());
			count++;
		}
		return ans;
	}
}
