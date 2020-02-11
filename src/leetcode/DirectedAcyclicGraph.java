package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class DirectedAcyclicGraph {

	public DirectedAcyclicGraph() {
		// TODO Auto-generated constructor stub
	}

	private static boolean flag = true;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] data = input.split(" ");
		HashMap<String, List<String>> map = new HashMap();
		Set<String> set = new HashSet();
		Set<String> set2 = new HashSet();
		String start = "";
		for (int i = 0; i < data.length; i++) {
			String s = data[i];
			String[] sp = s.split("|");
			map.putIfAbsent(sp[0], new ArrayList());
			List<String> l = map.get(sp[0]);
			l.add(sp[2]);
			map.put(sp[0], l);
			set.add(sp[0]);
			set.add(sp[2]);
			set2.add(sp[2]);
		}
		for (String s : set) {
			if (!set2.contains(s)) {
				start = s;
				break;
			}
		}
		if (start.equals("")) {
			// have circle
			Set<String> check = new HashSet();
			int count = 0;
			for (String d : data) {
				String[] dsp = d.split("|");
				String d1 = dsp[0];
				String d2 = dsp[2];
				if(check.contains(d2)) {
					System.out.println(d);
					return;
				}
				if(count==0) {
					check.add(d2);
					check.add(d1);
				}else {
					check.add(d2);
				}
			}
		}
		List<String> res = new ArrayList();
		boolean[] visit = new boolean[set.size()];
		dfs(map, visit, res, start.charAt(0));
		for (String s : res) {
			if (flag) {
				System.out.print(s + ";");
			} else {
				System.out.print(s);
			}

		}
	}

	public static void dfs(HashMap<String, List<String>> map, boolean[] visit, List<String> res, char start) {
		if (flag) {
			String s = "" + start;
			System.out.println(s);
			visit[start - 'A'] = true;
			res.add(s);
			if (!map.containsKey(s)) {
				return;
			}
			Set<String> s1 = new HashSet();
			Set<String> s2 = new HashSet();
			String newStart = "";
			Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, List<String>> entry = iterator.next();
				String from = entry.getKey();
				List<String> go = entry.getValue();
				if (!visit[from.charAt(0) - 'A']) {
					s1.add(from);
					for (String g : go) {
						if (!visit[g.charAt(0) - 'A']) {
							s1.add(g);
							s2.add(g);
						}
					}
				} else {
					for (String g : go) {
						if (!visit[g.charAt(0) - 'A']) {
							s1.add(g);
						}
					}
				}

			}
			for (String ss : s1) {
				if (!s2.contains(ss)) {
					newStart = ss;
					dfs(map, visit, res, newStart.charAt(0));
				}
			}
			if (newStart.equals("")) {
				flag = false;
				res.clear();
				res.add(s);
				res.add("|");
				res.add(map.get(s).get(0));
				res.add(";");
			}
		}
	}
}
