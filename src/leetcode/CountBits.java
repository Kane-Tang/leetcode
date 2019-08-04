package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountBits {
	public int[] countBits(int num) {
		//List<Integer> list = new ArrayList();
//		for(int i=0;i<=num;i++) {
//			List<Integer> tmp = new ArrayList();
//			int n=i;
//			while(true) {
//				int a = n%2;
//				tmp.add(a);
//				n = n/2;
//				if(n<=1) {
//					tmp.add(n);
//					break;
//				}
//			}
//			int count = 0;
//			for(int j=0;j<tmp.size();j++) {
//				if(tmp.get(j)==1) {
//					count++;
//				}
//			}
//			list.add(count);
//		}
//		for(int i=0;i<=num;i++) {
//			int n = i;
//			int count = 0;
//			while(true) {
//				int a = n%2;
//				if(a==1) {
//					count++;
//				}
//				n = n/2;
//				if(n<=1) {
//					if(n==1)
//						count++;
//					break;
//				}
//			}
//			list.add(count);
//		}
//		int[] ans = new int[list.size()];
//		for(int i=0;i<list.size();i++) {
//			ans[i] = list.get(i);
//		}
//		return ans;
		int[] ans = new int[num+1];
		//P(x+b)=P(x)+1,b=2^m>x
		int i=0;
		int b=1;
		while(b<=num) {
			while(i<b && i+b<=num) {
				ans[i+b] = ans[i]+1;
				i++;
			}
			i=0;
			b=b*2;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		CountBits cb = new CountBits();
		int[] ans = cb.countBits(5);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}
}
