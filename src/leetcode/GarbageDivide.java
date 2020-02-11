package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class GarbageDivide {

	public GarbageDivide() {
		// TODO Auto-generated constructor stub
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		// color question
		HashMap<Integer, List<Integer>> count = new HashMap();
		for (int i = 0; i < m; i++) {
			int o1 = in.nextInt();
			int o2 = in.nextInt();

			if (count.containsKey(o1)) {
				List<Integer> l = count.get(o1);
				l.add(o2);
				count.put(o1, l);
			} else {
				List<Integer> l = new ArrayList();
				l.add(o2);
				count.put(o1, l);
			}

			if (count.containsKey(o2)) {
				List<Integer> l = count.get(o2);
				l.add(o1);
				count.put(o2, l);
			} else {
				List<Integer> l = new ArrayList();
				l.add(o1);
				count.put(o2, l);
			}
		}

		boolean[] visited = new boolean[n + 1];
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				sum += dfs(count, visited, i, n);
				System.out.println(sum);
			}
		}
		if (sum % 2 == 0) {
			System.out.println(sum);
		} else {
			System.out.println(sum - 1);
		}

//		Set<Integer> set = new HashSet();
//		for(int i=1;i<=n;i++) {
//			if(set.isEmpty()) {
//				set.add(i);
//			}
//			List<Integer> limit = count.get(i);
//			if(limit != null) {
//				for(Integer num: limit) {
//					if(set.contains(num)) {
//						//conflicts
//						continue;
//					}
//				}
//			}
//			set.add(i);
//		}
//		System.out.println(set.size());
	}

	public static int dfs(HashMap<Integer, List<Integer>> count, boolean[] visit, int start, int n) {
		int[] color = new int[n + 1];
		visit[start] = true;
		color[start] = 1;
		if (!count.containsKey(start)) {
			return 1;
		}
		for (Integer i : count.get(start)) {
			if (!visit[i]) {
				fillColor(count, visit, color, i, -1);
			}
		}
		int res = 0;
		for (int i = 0; i < color.length; i++) {
			//System.out.println(color[i]);
			res += Math.abs(color[i]);
		}
		return res;
	}

	public static void fillColor(HashMap<Integer, List<Integer>> count, boolean[] visit, int[] colors, int start,
			int color) {
		visit[start] = true;
		colors[start] = color;
		for (Integer i : count.get(start)) {
			if (colors[i] == color) {
				colors[start] = 0;
				return;
			}
			if (!visit[i]) {
				fillColor(count, visit, colors, i, -color);
			}
		}
	}
}
