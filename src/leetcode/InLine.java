package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class InLine {

	public InLine() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] customer = new int[n][2];
		for(int i=0;i<n;i++) {
			customer[i][0] = in.nextInt();
			customer[i][1] = in.nextInt();
		}
		Arrays.sort(customer);
		//ai*(j-1)+bi*(n-j)
		for(int i=0;i<n;i++) {
			
		}
	}
}
