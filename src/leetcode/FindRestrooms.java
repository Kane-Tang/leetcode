package leetcode;

import java.util.Scanner;

public class FindRestrooms {

	public FindRestrooms() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			if(s.charAt(i)=='O') {
				arr[i] = 0;
			}else {
				int res = Integer.MAX_VALUE;
				int pointer = i;
				//to left
				int dis = 0;
				while(pointer>=0) {
					if(s.charAt(pointer)=='O') {
						res = dis;
						break;
					}else {
						dis++;
						pointer--;
					}
				}
				pointer = i;
				int dis2 = 0;
				while(pointer<n) {
					if(s.charAt(pointer)=='O') {
						res = Math.min(res, dis2);
						break;
					}else {
						pointer++;
						dis2++;
					}
				}
				arr[i] = res;
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
