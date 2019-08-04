package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Building {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			int n = in.nextInt();
			int[] data = new int[n];
			int max = 0;
 			for(int j=0;j<n;j++) {
				data[j] = in.nextInt();
				if(data[j]>max) {
					max = data[j];
				}
			}
 			List<Integer> list = new ArrayList();
 			for(int j=0;j<n;j++) {
 				if(data[j] == max) {
 					list.add(data[j]);
 					for(int q=list.size()-1;q>=0;q--) {
 						System.out.print(list.get(q)+" ");
 					}
 					System.out.println();
 					list.clear();
 					max--;
 				}
 				else {
 					list.add(data[j]);
 					System.out.println();
 				}
 			}
		}	
	}
}
