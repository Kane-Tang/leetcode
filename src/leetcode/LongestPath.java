package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LongestPath {

	public LongestPath() {
		// TODO Auto-generated constructor stub
	}

	static int ans = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] v = new int[n+1];
		for(int i=1;i<=n;i++) {
			v[i] = in.nextInt();
		}
		HashMap<Integer, List<Integer>> edge = new HashMap();
		for(int i=1;i<n;i++) {
			int p1 = in.nextInt();
			int p2 = in.nextInt();
			edge.putIfAbsent(p1, new ArrayList());
			edge.putIfAbsent(p2, new ArrayList());
			List<Integer> l1 = edge.get(p1);
			l1.add(p2);
			edge.put(p1, l1);
			List<Integer> l2 = edge.get(p2);
			l2.add(p1);
			edge.put(p2, l2);
		}
		dfs(edge, v, 1);
		System.out.println(ans);
	}
	
	public static int dfs(HashMap<Integer, List<Integer>> edge, int[] v, int start) {
		if(!edge.containsKey(start)) {
			return 1;
		}
		List<Integer> list = edge.get(start);
		int res = 1;
		for(Integer i: list) {
			if(v[i] > v[start]) {
				res = Math.max(res, 1+dfs(edge, v, i));
			}
		}
		ans = Math.max(ans, res);
		return res;
	}
}
