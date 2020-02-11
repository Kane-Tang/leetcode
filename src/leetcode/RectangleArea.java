package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RectangleArea {

	public RectangleArea() {
		// TODO Auto-generated constructor stub
	}

	public int rectangleArea(int[][] rectangles) {
		int l = rectangles.length;
		// line sweep
		int mod = (int) (Math.pow(10, 9) + 7);
		long res = 0;
		List<int[]> recList = new ArrayList();
		for (int[] rec : rectangles) {
			addRectangle(recList, rec, 0);
		}
		for (int[] rec : recList) {
			res = (res + ((long) (rec[2] - rec[0]) * (long) (rec[3] - rec[1]))) % mod;
		}
		return (int) res % mod;
	}

	public void addRectangle(List<int[]> list, int[] rec, int start) {
		if (start >= list.size()) {
			list.add(rec);
			return;
		}
		int[] r = list.get(start);

		// no overlap
		if (rec[2] <= r[0] || rec[3] <= r[1] || rec[0] >= r[2] || rec[1] >= r[3]) {
			addRectangle(list, rec, start + 1);
			return;
		}

		if (rec[0] < r[0])
			addRectangle(list, new int[] { rec[0], rec[1], r[0], rec[3] }, start + 1);

		if (rec[2] > r[2])
			addRectangle(list, new int[] { r[2], rec[1], rec[2], rec[3] }, start + 1);

		if (rec[1] < r[1])
			addRectangle(list, new int[] { Math.max(r[0], rec[0]), rec[1], Math.min(r[2], rec[2]), r[1] }, start + 1);

		if (rec[3] > r[3])
			addRectangle(list, new int[] { Math.max(r[0], rec[0]), r[3], Math.min(r[2], rec[2]), rec[3] }, start + 1);
	}
}
