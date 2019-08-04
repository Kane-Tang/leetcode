package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MeetingRoom {
	public int minMeetingRooms(int[][] intervals) {
		int l = intervals.length;
		if(l==0) {
			return 0;
		}
//		LinkedHashMap<Integer,Integer> list = new LinkedHashMap();
//		for(int i=0;i<l;i++) {
//			list.put(intervals[i][0], intervals[i][1]);
//		}
//		List<Map.Entry<Integer,Integer>> data = new ArrayList<Map.Entry<Integer,Integer>>(list.entrySet());
//		Collections.sort(data, new Comparator<Map.Entry<Integer,Integer>>(){
//			 public int compare(Entry<Integer, Integer> o1,
//	                    Entry<Integer, Integer> o2) {
//	                return o1.getValue().compareTo(o2.getValue());
//	            }
//		});
		quickSort(intervals, 0, l-1);
		int room = 1;
		int start = 0;
		int end = 0;
		List<Integer> check = new ArrayList();
		for(int i=0;i<l;i++) {
			int s = intervals[i][0];
			int e = intervals[i][1];
			if(i==0) {
				start = s;
				end = e;
				check.add(e);
			}else {
				if(s<end) {
					room++;
					check.add(e);
					end = Math.min(e, end);	
				}else {
					int index = check.indexOf(end);
					check.remove(index);
					check.add(e);
					end = check.get(0);
					for(int tmp: check) {
						if(tmp<end) {
							end = tmp;
						}
					}
				}
			}
		}
		return room;
	}
	
	public void quickSort(int[][] nums, int low, int high) {
		if(low<high) {
			int par = partition(nums, low, high);
			quickSort(nums, low, par-1);
			quickSort(nums, par+1, high);
		}
	}
	
	public int partition(int[][] nums, int low, int high) {
		int par = nums[high][0];
		int i = low-1;
		for(int j = low;j<high;j++) {
			if(nums[j][0]<=par) {
				i++;
				int temp1 = nums[j][0];
				int temp2 = nums[j][1];
				nums[j][0] = nums[i][0];
				nums[j][1] = nums[i][1];
				nums[i][0] = temp1;
				nums[i][1] = temp2;
			}
		}
		
		int temp1 = nums[i+1][0];
		int temp2 = nums[i+1][1];
		nums[i+1][0] = nums[high][0];
		nums[i+1][1] = nums[high][1];
		nums[high][0] = temp1;
		nums[high][1] = temp2;
		return i+1;
	}
	
	public static void main(String[] args) {
		MeetingRoom mr = new MeetingRoom();
		int[][] intervals = new int[][] {{2, 15},{36, 45},{9, 29},{16,23},{4,9}};
		int ans = mr.minMeetingRooms(intervals);
		System.out.println(ans);
	}
}
