package leetcode;

public class MinStation {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int l = stations.length;
		// dynamic
		if (startFuel >= target) {
			return 0;
		}
		// int stop = 0;
//		int stop = getNumOfStop(0, target, startFuel, 0, stations);
//		if(stop>=1000) {
//			stop = -1;
//		}

		// dp
		int[] fules = new int[l+1];//represents with i stops the farthest point we can get to
		fules[0] = startFuel;
		for (int i = 0; i < l; i++) {
			for (int j = i; j >= 0; j--) {//backtrack
				if (fules[j] >= stations[i][0]) {
					fules[j + 1] = Math.max(fules[j + 1], fules[j] + stations[i][1]);
				}
			}
		}
		for (int i = 0; i < l; i++) {
			if (fules[i] >= target) {
				return i;
			}
		}
		return -1;
	}

	// backtrack
	public int getNumOfStop(int start, int target, int fuel, int index, int[][] stations) {
		if (target - start <= fuel) {
			return 0;
		} else if (index >= stations.length) {
			return 1000;
		} else if (stations[index][0] - start > fuel) {
			return 1000;
		}
		return Math.min(
				getNumOfStop(stations[index][0], target, fuel - stations[index][0] + start + stations[index][1],
						index + 1, stations) + 1,
				getNumOfStop(stations[index][0], target, fuel - stations[index][0] + start, index + 1, stations));
	}

	public static void main(String[] args) {
		MinStation ms = new MinStation();
		int[][] stations = new int[][] { { 10, 60 }, { 20, 30 }, { 30, 30 }, { 60, 40 } };
		System.out.println(ms.minRefuelStops(100, 10, stations));
	}
}
