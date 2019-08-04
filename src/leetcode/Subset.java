package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subset {
	public List<List<Integer>> subsets(int[] nums) {
		int l = nums.length;
		//quickSort(nums,0,l-1);
		List<List<Integer>> list = new ArrayList();
		for(int i=0;i<=l;i++) {
			findAns(nums, list, i, 0, new ArrayList());
		}
		return list;
	}
	
	public void findAns(int[] nums, List<List<Integer>> list, int count, int start, List<Integer> tmp) {
		if(count == 0) {
			list.add(new ArrayList(tmp));
		}else {
			for(int i=start;i<=nums.length-count;i++) {
				tmp.add(nums[i]);
				findAns(nums, list, count-1, i+1, tmp);
				tmp.remove(tmp.size()-1);
			}
		}
	}
	
	public void quickSort(int[] nums, int low, int high) {
		if(low<high) {
			int par = partitions(nums, low, high);
			quickSort(nums, low, par-1);
			quickSort(nums, par+1, high);
		}
	}
	
	public int partitions(int[] nums, int low, int high) {
		int par = nums[high];
		int i = low-1;
		for(int j = low;j<high;j++) {
			if(nums[j]<par) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		int tmp = nums[i+1];
		nums[i+1] = nums[high];
		nums[high] = tmp;
		return i+1;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList();
		while(true) {
			String s = in.nextLine().trim();
			if(s.equals("")) {
				break;
			}
			list.add(Integer.valueOf(s));
		}
		int l = list.size();
		int[] nums = new int[l];
		for(int i=0;i<l;i++) {
			nums[i] = list.get(i);
		}

		Subset s = new Subset();
		List<List<Integer>> ans = s.subsets(nums);
		for(int i=0;i<ans.size();i++) {
			for(int j=0;j<ans.get(i).size();j++) {
				System.out.print(ans.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
