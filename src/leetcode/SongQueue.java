package leetcode;

import java.util.Scanner;

public class SongQueue {

	public SongQueue() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] h = new int[n];
		for(int i=0;i<n;i++) {
			h[i] = in.nextInt();
		}
		int ans = n;
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i=1;i<n;i++) {
			if(h[i]<h[i-1]) {
				dp[i] = dp[i-1];
			}else {
				dp[i] = dp[i-1]+1;
			}
		}
//		dp[1] = 1;
//		for(int i=2;i<n;i++) {
//			if(h[i-1]<h[i-2] && h[i-1]<h[i]) {
//				dp[i] = dp[i-1]+1;
//			}else {
//				dp[i] = dp[i-1];
//			}
//		}
		ans = dp[n-1];
		System.out.println(ans);
	}
}
