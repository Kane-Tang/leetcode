package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	//if an array just be declared and no assignment, the value of each entry is null
	Integer memo[][];
	public int minimumTotal(List<List<Integer>> triangle) {
		int levels = triangle.size();
		memo = new Integer[triangle.size()][triangle.size()];
		return findShortestPath(triangle,0,0);
	}
	
	public int findShortestPath(List<List<Integer>> triangle, int level, int index) {
		if(level == triangle.size()-1) {
			return triangle.get(level).get(index);
		}
		Integer cache = memo[level][index];
		if(cache == null) {
			int ans = triangle.get(level).get(index);
			//System.out.println(ans);
			int left = findShortestPath(triangle, level + 1, index);
			int right = findShortestPath(triangle, level + 1, index + 1);
			ans += Math.min(left, right);
			memo[level][index] = ans;
			return ans;
		}
		return cache;
	}
	
	public static void main(String[] args) {
		Triangle t = new Triangle();
		List<List<Integer>> triangle = new ArrayList();
		List<Integer> l1 = new ArrayList();
		l1.add(-1);
		triangle.add(l1);
		List<Integer> l2 = new ArrayList();
		l2.add(2);
		l2.add(3);
		triangle.add(l2);
		List<Integer> l3 = new ArrayList();
		l3.add(1);
		l3.add(-1);
		l3.add(-3);
		triangle.add(l3);
		System.out.println(t.minimumTotal(triangle));
	}
}
