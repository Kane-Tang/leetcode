package leetcode;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class NumOfCows {
	public int count(int n) {
		int ans = 1;
		int[] list = new int[1000];
		list[0] = 1;
		int index = 1;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<1000;j++) {
				if(list[j]!=0) {
					if(list[j]>10) {
						ans--;
					}else if(list[j]>=3&&list[j]<=7){
						ans++;
						list[index] = 1;
						index++;
					}
					list[j]++;
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		NumOfCows nc = new NumOfCows();
		System.out.println(nc.count(n));
	}
}
