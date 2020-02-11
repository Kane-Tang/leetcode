package leetcode;

import java.util.Arrays;

public class SquareOfSortedArray {

	public SquareOfSortedArray() {
		// TODO Auto-generated constructor stub
	}

	public int[] sortedSquares(int[] A) {
//		int[] ans = new int[A.length];
//		for(int i=0;i<A.length;i++) {
//			ans[i] = A[i]*A[i];
//		}
//		Arrays.sort(ans);
//		return ans;
		
		int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
	}
}
