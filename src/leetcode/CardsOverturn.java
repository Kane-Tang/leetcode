package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class CardsOverturn {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int ans = 0;
		int index = n-1;
		while(index>=0) {
			ans += a[index--];
			if(index>=0) {
				ans -= a[index--];
			}
		}
		System.out.println(ans);
	}
}
