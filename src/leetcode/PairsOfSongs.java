package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsOfSongs {

	public PairsOfSongs() {
		// TODO Auto-generated constructor stub
	}

	public int numPairsDivisibleBy60(int[] time) {
		Arrays.sort(time);
        Map<Integer, Integer> map = new HashMap<>();
        int key = 0, total = 0;
        for (int t : time) {
            key = 60 - (t % 60);
            if (map.containsKey(key)) {
                total += map.get(key);
            }
            if (t % 60 == 0) {
                map.put(60, map.getOrDefault(60, 0) + 1);
            } else {
                map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
            }
        }
        return total;
	}
}
