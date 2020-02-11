package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinElement {

	public FindMinElement() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<k;i++) {
			//k round
			int ans = 0;
			for(int j=0;j<n;j++) {
				if(arr[j] != 0) {
					ans = arr[j];
					break;
				}
			}
			System.out.println(ans);
			for(int j=0;j<n;j++) {
				if(arr[j]!=0)
					arr[j] -= ans;
			}
		}
	}
}
