package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class NonOverlappingInterval {
	public int eraseOverlapIntervals(int[][] intervals) {
		int l = intervals.length;
		if(l==0){
            return 0;
        }
		Interval[] data = new Interval[l];
		for(int i=0;i<l;i++) {
			data[i] = new Interval();
			data[i].start = intervals[i][0];
			data[i].end = intervals[i][1];
		}
		
		Arrays.sort(data, new Comparator<Interval>() {
			@Override
			 public int compare(Interval a, Interval b) {
	            return a.end - b.end;
	        }
		});
		
		//find the most number of un-overlapping intervals
		//dp[i] stores the maximum number of valid intervals that can be included in the final list, only
		//considering the first i intervals
		int[] dp = new int[l];
		dp[0] = 1;
		int ans = 1;
		for(int i=1;i<l;i++) {
			//first i intervals
			int num = 0;
			for(int j=i-1;j>=0;j--) {
				if(!isOverlapping(data[j], data[i])) {
					num = Math.max(dp[j], num);
					continue;
				}else {
					break;
				}
			}
			dp[i] = Math.max(num+1, dp[i-1]);
			ans = Math.max(ans, dp[i]);
		}
		return l-ans;
	}
	
	public boolean isOverlapping(Interval a, Interval b) {
		if(a.end>b.start) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1,2},{2,3},{3,4},{1,3}};
		NonOverlappingInterval noi = new NonOverlappingInterval();
		System.out.println(noi.eraseOverlapIntervals(intervals));
	}
}
