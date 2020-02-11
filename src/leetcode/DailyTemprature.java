package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class DailyTemprature {

	public DailyTemprature() {
		// TODO Auto-generated constructor stub
	}

	public int[] dailyTemperatures(int[] T) {
		int l = T.length;
		int[] ans = new int[l];
		int[] next = new int[101];//temp is between 30 and 100, for next[j], it means for temp j, the next warmer date is next[j]
		Arrays.fill(next, Integer.MAX_VALUE);
		for(int i=l-1;i>=0;i--) {//need to do it backwards, to make sure we can always find the smallest one
			//which can make sure each next[j] is available, because the value of all found next[j] > i
			//the ith day, temp is T[i]
			int nextDate = Integer.MAX_VALUE;
			for(int j=T[i]+1;j<=100;j++) {
				if(next[j] < nextDate) {
					nextDate = next[j];
				}
			}
			if(nextDate<Integer.MAX_VALUE) {
				ans[i] = nextDate-i;
			}
			next[T[i]] = i;
		}
		return ans;
	}

}
