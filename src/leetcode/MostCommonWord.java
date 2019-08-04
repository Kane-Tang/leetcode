package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		String s = paragraph.toLowerCase();
		s = s.replace(",", " ");
		s = s.replace(".", " ");
		s = s.replace("!", " ");
		s = s.replace("?", " ");
		s = s.replace(";", " ");
		s = s.replace("'", " ");
		s = s.replaceAll("\\s+", " ");//remove multiple whitespace
		String[] str = s.split(" ");
		int l = str.length;
		LinkedHashMap<String, Integer> list = new LinkedHashMap();
		for(int i=0;i<l;i++) {
				if (!list.containsKey(str[i])) {
					list.put(str[i], 1);
				} else {
					list.put(str[i], list.get(str[i]).intValue() + 1);
				}
		}
		Iterator<Entry<String, Integer>> iterator = list.entrySet().iterator();
		int max = 0;
		String ans = "";
		while(iterator.hasNext()) {
			Entry<String,Integer> entry = iterator.next();
			if(entry.getValue()>max && !contain(banned, entry.getKey())) {
				StringBuilder ss = new StringBuilder();
				ss.append(entry.getKey());
				ans = ss.toString();
				max = entry.getValue();
			}
		}
		return ans;
	}
	
	public boolean contain(String[] banned, String val) {
		for(int i=0;i<banned.length;i++) {
			if(banned[i].equals(val)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MostCommonWord mcw = new MostCommonWord();
		String paragraph = "Bob. hIt, baLl";
		String[] banned = new String[] {"bob", "hit"};
		System.out.println(mcw.mostCommonWord(paragraph, banned));
	}
}
