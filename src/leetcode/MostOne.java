package leetcode;

import java.util.Scanner;

public class MostOne {
	public int calculate(int[] data,int k) {
		int res = traverse(data);
		int t = k;
		for(int j=0;j<data.length;j++) {
			k = t;
			int[] check = new int[data.length];
			for(int i=0;i<j;i++) {
				check[i] = data[i];
			}
			for (int i = j; i < data.length; i++) {
				if (data[i] == 0) {
					if(k==0) {
						break;
					}	
					check[i] = 1;
					k--;
					
				}else {
					check[i] = data[i];
				}
			}
//			for(int i=0;i<data.length;i++) {
//				System.out.print(check[i]);
//			}
//			System.out.println();
			int tmp = traverse(check);
			res = Math.max(res, tmp);
		}
		return res;
		
	}
	
	public int traverse(int[] data) {
		int l = 0;
		int ans = 0;
		for(int i=0;i<data.length;i++) {
			if(data[i]==1) {
				l++;
			}else {
				ans = Math.max(ans, l);
				l=0;
			}
		}
		ans = Math.max(ans, l);
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] data = new int[n];
		for(int i=0;i<n;i++) {
			data[i] = in.nextInt();
		}
		MostOne mo = new MostOne();
		System.out.println(mo.calculate(data, k));
	}
}
