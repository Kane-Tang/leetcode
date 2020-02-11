package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Group {

	public Group() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j=0;j<n;j++) {
				arr[j] = in.nextInt();
			}
			Arrays.sort(arr);
			Set<Integer> s1 = new HashSet();
			Set<Integer> s2 = new HashSet();
			int flag = 1;//s1 has the larger one
			int pointer = n-1;
			while(pointer >= 0) {
				if(flag == 1) {
					s1.add(arr[pointer--]);
					if(pointer>=0)
						s2.add(arr[pointer--]);
				}else {
					s2.add(arr[pointer--]);
					if(pointer>=0)
						s1.add(arr[pointer--]);
				}
				
				int sum1 = 0;
				Iterator<Integer> it1 = s1.iterator();
				while(it1.hasNext()) {
					sum1 += it1.next();
				}
				int sum2 = 0;
				Iterator<Integer> it2 = s2.iterator();
				while(it2.hasNext()) {
					sum2 += it2.next();
				}
				if(sum1 < sum2) {
					flag = 1;
				}else {
					flag = 2;
				}
				if(pointer < 0) {
					if(flag == 1) {
						System.out.println(sum1+" "+sum2);
					}else {
						System.out.println(sum2+" "+sum1);
					}
					break;
				}
			}
		}
	}

}