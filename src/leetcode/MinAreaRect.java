package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MinAreaRect {

	public MinAreaRect() {
		// TODO Auto-generated constructor stub
	}

	public int minAreaRect(int[][] points) {
		int l = points.length;
		int ans = 0;
		HashMap<Integer, Set<Integer>> map = new HashMap();
		for(int[] point: points) {
			if(!map.containsKey(point[0])) {
				Set<Integer> set = new HashSet();
				set.add(point[1]);
				map.put(point[0], set);
			}else {
				map.get(point[0]).add(point[1]);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int[] p1: points) {
			for(int[] p2: points) {
				if(p1[0]== p2[0] || p1[1]==p2[1]) {
					continue;
				}else {
					if(map.containsKey(p1[0]) && map.containsKey(p2[0])) {
						if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
							min = Math.min(min, Math.abs(p1[0]-p2[0])*Math.abs(p1[1]-p2[1]));
						}
					}
				}
			}
		}
		if(min == Integer.MAX_VALUE) {
			return 0;
		}
		return min;
	}
}
