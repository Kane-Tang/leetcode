package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> list = new ArrayList();
		int length = nums.length;
		//len = nums.length;
		Arrays.sort(nums);
		return kSum(nums, target, 4, 0);
	}

	private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
		int len = nums.length;
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (index >= len) {
			return res;
		}
		if (k == 2) {//2 sum, where find two items whose sum is equal to target
			int i = index, j = len - 1;
			while (i < j) {
				// find a pair
				if (target - nums[i] == nums[j]) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(target - nums[i]);
					res.add(temp);
					// skip duplication
					while (i < j && nums[i] == nums[i + 1])
						i++;
					while (i < j && nums[j - 1] == nums[j])
						j--;
					i++;
					j--;
					// move left bound
				} else if (target - nums[i] > nums[j]) {
					i++;
					// move right bound
				} else {
					j--;
				}
			}
		} else {//3 or 4 sum
			for (int i = index; i < len - k + 1; i++) {
				// use current number to reduce ksum into k-1sum
				ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
				if (temp != null) {
					// add previous results
					for (List<Integer> t : temp) {
						t.add(0, nums[i]);
					}
					res.addAll(temp);
				}
				while (i < len - 1 && nums[i] == nums[i + 1]) {
					// skip duplicated numbers
					i++;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		FourSum fs = new FourSum();
		int[] nums = new int[] {1, 0, -1, 0, 2, -2};
		int target = 0;
		System.out.println(fs.fourSum(nums, target));
	}
}
