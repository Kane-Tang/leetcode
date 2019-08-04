package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card {
	public List<Integer> findWin(int[] data) {
		quickSort(data,0,data.length-1);
		int l = data.length;
		List<Integer> ans = new ArrayList();
		int label = 0;
		for(int j=1;j<=36;j++) {
//			if(AsHead(data,j)) {
//				ans.add(j);
//				continue;
//			}else if(AsCon(data,j)) {
//				ans.add(j);
//				continue;
//			}else if(AsSame(data,j)) {
//				ans.add(j);
//			}
		}
		return ans;
	}
//	
//	public boolean AsHead(int[] data,int num) {
//		int l = data.length;
//		for()
//	}
	
	
	
	public void quickSort(int[] nums, int low, int high) {
		if(low<high) {
			int par = partition(nums, low, high);
			quickSort(nums, low, par-1);
			quickSort(nums, par+1, high);
		}
	}
	
	public int partition(int[] nums, int low, int high) {
		int par = nums[high];
		int i = low-1;
		for(int j = low;j<high;j++) {
			if(nums[j]<=par) {
				i++;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}
		
		int temp = nums[i+1];
		nums[i+1] = nums[high];
		nums[high] = temp;
		return i+1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList();
		while(in.hasNextInt()) {
			list.add(in.nextInt());
		}
		int[] data = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			data[i] = list.get(i);
		} 
		Card c = new Card();
		System.out.println(c.findWin(data));
	}
}
