package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinSum {

	public FindMinSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] = in.nextInt();
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<n-m+1;i++) {
			int tmp = 0;
			for(int j=i;j<n&&j<i+m;j++) {
				tmp += array[j];
			}
			int sum = tmp;
			int pointer = i+m;
			while(pointer<n) {
				tmp += array[pointer++];
				sum = Math.min(sum, tmp);
			}
			ans = Math.min(ans, sum);
		}
		
		//dp
		int[] dp = new int[n];
		int[] sum = new int[n];
		sum[0] = array[0];
		dp[0] = array[0];
		for(int i=1;i<n;i++) {
			sum[i] = sum[i-1]+array[i];
			if(i-m>=0)
				dp[i] = Math.min(dp[i-1]+array[i], sum[i]-sum[i-m]);
			else
				dp[i] = sum[i];
		}
		ans = Integer.MAX_VALUE;
		for(int i=m-1;i<n;i++) {
			if(dp[i]<ans) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}
}
