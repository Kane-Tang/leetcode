package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TopElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		int l = nums.length;
		HashMap<Integer,Integer> hm = new HashMap();
		for(int i=0;i<l;i++) {
			if(hm.containsKey(nums[i])) {
				int count = hm.get(nums[i]);
				hm.remove(nums[i]);
				hm.put(nums[i], count+1);
			}else {
				hm.put(nums[i], 1);
			}
		}
		
		List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(hm.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
			public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		List<Integer> ans = new ArrayList();
		for(int i=list.size()-1;i>=list.size()-k;i--) {
			ans.add(list.get(i).getKey());
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> input = new ArrayList();
		while(sc.hasNextInt()) {
			int tmp = sc.nextInt();
			input.add(tmp);
			//System.out.println("here");
		}
		int[] nums = new int[input.size()];
		for(int i=0;i<input.size();i++) {
			nums[i] = input.get(i);
		}
		TopElements te = new TopElements();
		te.topKFrequent(nums, 3);
	}
}
