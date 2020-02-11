package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PrisonCellAfterNDays {

	public PrisonCellAfterNDays() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap();

        // state  = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (N > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;//it means the length of the cycle is seen.get(state)-N, so we can jump to n%(seen.get(state)-N)
            }
            seen.put(state, N);
            

            if (N >= 1) {
                N--;
                state = nextDay(state);
            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }

//	private int count = 0;
//	private int[] ans;
//	private HashMap<int[], int[]> mem = new HashMap();
//
//	public int[] prisonAfterNDays(int[] cells, int N) {
//		ans = new int[cells.length];
//		traverse(cells, N);
//		return ans;
//	}
//
//	public void traverse(int[] cells, int n) {
//		if (count >= n) {
//			for (int i = 0; i < cells.length; i++) {
//				ans[i] = cells[i];
//			}
//			return;
//		}
//		if (this.mem.containsKey(cells)) {
//			count++;
//			traverse(this.mem.get(cells), n);
//		} else {
//			int l = cells.length;
//			int[] newCell = new int[l];
//			for (int i = 0; i < l; i++) {
//				if (i - 1 >= 0 && i + 1 < l) {
//					if (cells[i - 1] == 1 && cells[i + 1] == 1 || cells[i - 1] == 0 && cells[i + 1] == 0) {
//						newCell[i] = 1;
//					}
//				} else {
//					newCell[i] = 0;
//				}
//			}
//			count++;
//			traverse(newCell, n);
//		}
//	}
}
