package leetcode;

public class FindPeakElement {

	public FindPeakElement() {
		// TODO Auto-generated constructor stub
	}

	public int findPeakElement(int[] nums) {
		/*
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return i;
		}
		return nums.length - 1;
		*/
		
		//binary search
		int l = nums.length;
		int start = 0;
		int end = l-1;
		while(start<end) {
			int mid = (start+end)/2;
			if(nums[mid] > nums[mid+1]) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return start;
	}
}
