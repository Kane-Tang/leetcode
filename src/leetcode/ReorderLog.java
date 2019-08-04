package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class ReorderLog {
	public String[] reorderLogFiles(String[] logs) {
		int l = logs.length;
		HashMap<String, String> letter = new HashMap();
		LinkedHashMap<String, String> number = new LinkedHashMap();
		for (int i = 0; i < l; i++) {
			String s = logs[i];
			String[] check = s.split(" ");
			StringBuilder val = new StringBuilder();
			for (int j = 1; j < check.length; j++) {
				val.append(check[j]);
				val.append(" ");
			}
			if (check[1].charAt(0) <= '9' && check[1].charAt(0) >= '0') {
				// number
				number.put(val.toString(), check[0]);
			} else {
				letter.put(val.toString(), check[0]);
			}
		}
		String[] ans = new String[l];
		int pointer = 0;
		Iterator<Entry<String, String>> iterator1 = letter.entrySet().iterator();

		Collection<String> keyset = letter.keySet();
		List<String> list = new ArrayList<String>(keyset);

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			StringBuilder tmp = new StringBuilder();
			tmp.append(letter.get(list.get(i)));
			tmp.append(" ");
			tmp.append(list.get(i));
			ans[pointer] = tmp.toString();
			pointer++;
		 }

		Iterator<Entry<String, String>> iterator2 = number.entrySet().iterator();
		while (iterator2.hasNext()) {
			Entry<String, String> entry = iterator2.next();
			StringBuilder tmp = new StringBuilder();
			tmp.append(entry.getValue());
			tmp.append(" ");
			tmp.append(entry.getKey());
			ans[pointer] = tmp.toString();
			pointer++;
		}
		return ans;
	}

	public static void main(String[] args) {
		ReorderLog rl = new ReorderLog();
		String[] logs = new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };
		String[] ans = new String[logs.length];
		ans = rl.reorderLogFiles(logs);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
