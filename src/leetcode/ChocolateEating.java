package leetcode;

import java.util.Scanner;

public class ChocolateEating {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int res = findAns(n, m);
		System.out.println(res);
	}
	
	public static int findAns(int n, int m) {
		//bianry search
		if(n==1) {
			return m;
		}
		int low = 1;
		int high = m;
		while(low<high) {
			int mid = (low+high+1)/2;
			if(sum(mid,n)==m) {
				return mid;
			}else if(sum(mid,n)<m) {
				low = mid;
			}else {
				high = mid-1;
			}
		}
		return high;
	}
	
	public static int sum(int s, int n) {
		int ans = 0;
		for(int i=0;i<n;i++) {
			ans += s;
			s = (s+1)/2;
		}
		return ans;
	}
}
