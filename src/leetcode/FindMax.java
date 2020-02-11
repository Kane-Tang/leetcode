package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class FindMax {

	public FindMax() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong();
		}
		long k = 0;
		long max = a[0];
		Arrays.sort(a);
		if (a[n - 1] < n) {
			System.out.println(k);
			return;
		}
		for (int i = n - 1; i >= 0; i--) {
			if(a[i] - a[i-1] > 1) {
				k = n - i;
				break;
			}
		}
		System.out.println(k);
	}
}
