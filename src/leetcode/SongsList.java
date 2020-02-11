package leetcode;

import java.util.Scanner;

public class SongsList {
	//similar to 01 bag
	public static final int mod = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int a = in.nextInt();
		int x = in.nextInt();
		int b = in.nextInt();
		int y = in.nextInt();
		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i=0;i<x;i++) {
			for(int j=k;j>=a;j--) {
				dp[j] = (dp[j]+dp[j-a])%mod;
			}
		}
		for(int i=0;i<y;i++) {
			for(int j=k;j>=b;j--) {
				dp[j] = (dp[j]+dp[j-b])%mod;
			}
		}
		System.out.println(dp[k]);
	}
}
