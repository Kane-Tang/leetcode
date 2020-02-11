package leetcode;

import java.math.BigInteger;
import java.util.Scanner;

public class FinalSumUp {

	public FinalSumUp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] days = new int[n];
		for(int i=0;i<n;i++) {
			days[i] = in.nextInt();
		}
		//min*sum
		
		BigInteger r = BigInteger.ZERO;
		int min = 0;
		int sum = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				min = Integer.MAX_VALUE;
				sum = 0;
				for(int k=j;k<=j+i;k++) {
					sum += days[k];
					if(days[k]<min) {
						min = days[k];
					}
				}
				BigInteger t = new BigInteger(String.valueOf(min)).multiply(new BigInteger(String.valueOf(sum)));
				if(t.compareTo(r) > 0) {
					r = t;
				}
			}
		}
		System.out.println(r);
		
//		int min = days[0];
//		int[] dp = new int[n];
//		dp[0] = days[0]*days[0];
//		for(int i=1;i<n;i++) {
//			if(days[i] < min) {
//				int sum = dp[i-1]/min;
//				min = days[i];
//				sum += days[i];
//				dp[i] = min*sum;
//			}else {
//				dp[i] = (dp[i-1]/min+days[i])*min;
//			}
//		}
//		System.out.println(dp[n-1]); 
	}
}
