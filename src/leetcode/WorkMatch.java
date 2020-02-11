package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WorkMatch {

	public WorkMatch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer, Integer> count = new TreeMap();
		for(int i=0;i<n;i++) {
			int o2 = in.nextInt();
			int o1 = in.nextInt();
			count.put(o1, o2);
		}
		
		int pointer = 0;
		int sum = 0;
		List<Integer> list = new ArrayList();
		Iterator<Map.Entry<Integer, Integer>> iterator = count.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = iterator.next();
			sum += entry.getValue();
			for(int i=0;i<entry.getValue();i++) {
				list.add(entry.getKey());
			}
		}
		Collections.sort(list);
		int ans = Integer.MIN_VALUE;
		for(int i=0;i<list.size()/2;i++) {
			int t1 = list.get(i);
			int t2 = list.get(list.size()-1-i);
			ans = Math.max(ans, t1+t2);
		}
		System.out.println(ans);
	}
}
