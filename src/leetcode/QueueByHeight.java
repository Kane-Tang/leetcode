package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class QueueByHeight {

	public QueueByHeight() {
		// TODO Auto-generated constructor stub
	}

	public int[][] reconstructQueue(int[][] people) {
		int l = people.length;
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
			}
		});
		LinkedList<int[]> list = new LinkedList();
		for(int[] p: people) {
			list.add(p[1], p);
		}
		return list.toArray(new int[l][2]);
	}
}
