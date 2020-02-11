package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		int la = A.length;
		int lb = B.length;

		List<Integer> ans = new ArrayList();
		int i = 0;
		int j = 0;
		while (i < la && j < lb) {
			int lo = Math.max(A[i][0], B[j][0]);
			int hi = Math.min(A[i][1], B[j][1]);
			if (lo <= hi) {// have interval
				ans.add(lo);
				ans.add(hi);
			}
			// Remove the interval with the smallest endpoint
			if (A[i][1] < B[j][1]) {// remove the one on the left
				i++;
			} else {
				j++;
			}
		}
		int size = ans.size();
		int[][] res = new int[size / 2][2];
		int count = 0;
		for (int q = 0; q < size; q++) {
			res[count][0] = ans.get(q);
			res[count][1] = ans.get(++q);
			count++;
		}
		return res;
	}
}
