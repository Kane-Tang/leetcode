package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Count {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			List<Integer> list = new ArrayList();
			int a = in.nextInt();
			while(a>=1) {
				list.add(a%10);
				a = a/10;
			}
			int count=0;
			while(true) {
				int l = list.size();
				if(l==1||l==0) {
					if(count%2==0) {
						System.out.println("Oh no.");
					}else {
						System.out.println("Yes,you can win");
					}
					break;
				}
				for(int j=1;j<l;j++) {
					if(list.get(j)==list.get(j-1)) {
						list.remove(j);
						list.remove(j-1);
						count++;
						break;
					}
				}
				if(l==list.size()) {
					if(count%2==0) {
						System.out.println("Oh no.");
					}else {
						System.out.println("Yes,you can win");
					}
					break;
				}
			}
		}
	}
}
