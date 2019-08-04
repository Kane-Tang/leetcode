package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
//		int l = nums.length;
//		List<Integer> list = new ArrayList();
//		int count = 0;
//		for(int i=0;i<l;i++) {
//			if(nums[i] == 0) {
//				count++;
//			}else {
//				list.add(nums[i]);
//			}
//		}
//		for(int i=0;i<count;i++) {
//			list.add(0);
//		}
//		for(int i=0;i<l;i++) {
//			nums[i] = list.get(i);
//		}
		int l = nums.length;
		int count = 0;
		for(int i=0;i<l;i++) {
			if(nums[i] != 0) {
				nums[count] = nums[i];
				count++;
			}
		}
		for(int i=count;i<l;i++) {
			nums[i]=0;
		}
	}
}
