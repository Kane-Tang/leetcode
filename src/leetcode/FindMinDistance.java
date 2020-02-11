package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;

public class FindMinDistance {

	public FindMinDistance() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Integer, List<Integer>> relation = new HashMap();
		int start = 0;
		String input = "";
		while((input=in.nextLine()) != null) {
			if(input.isEmpty() || input.equals("")) {
				break;
			}
			String[] data = input.split(" ");
			List<Integer> list = new ArrayList();
			for(int i=1;i<data.length;i++) {
				list.add(Integer.parseInt(data[i]));
			}
			if(list.size() == 0) {
				start = Integer.parseInt(data[0]);
			}
			relation.put(Integer.parseInt(data[0]), list);
		}
		
		boolean[] visit = new boolean[100000];
		List<Integer> res = new ArrayList();
		List<Integer> next = new ArrayList();
		dfs(start, relation, visit, next, res);
		if(res.size() < relation.size()) {
			System.out.println(-1);
			return;
		}
		for(int i=0;i<res.size();i++) {
			System.out.print(res.get(i)+" ");
		}
	}
	
	public static void dfs(int pos, HashMap<Integer, List<Integer>> relation, boolean[] visit, List<Integer> next, List<Integer> res) {
		res.add(pos);
		visit[pos] = true;
		Iterator<Map.Entry<Integer, List<Integer>>> iterator = relation.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, List<Integer>> entry = iterator.next();
			List<Integer> list = entry.getValue();
			if(list.contains(pos)) {
				next.add(entry.getKey());
			}	
		}
		List<Integer> newList = new ArrayList();
		for(int i=0;i<next.size();i++) {
			newList.add(next.get(i));
		}
		Collections.sort(newList);
		for(int i: newList) {
			if(!visit[i]) {
				dfs(i, relation, visit, next, res);
			}
		}
	}

}
