package leetcode;

public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		int l = nums.length;
		quickSort(nums, 0, l-1);
		return nums[l-k];
	}
	
	public void quickSort(int[] nums, int low, int high) {
		if(low<high) {
			int par = partition(nums, low, high);
			quickSort(nums, low, par-1);
			quickSort(nums, par+1, high);
		}
	}
	
	public int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low-1;
		for(int j=low;j<high;j++) {
			if(nums[j]<=pivot) {
				i++;
				int temp = nums[i];//swap
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		
		int temp = nums[i+1];
		nums[i+1] = nums[high];
		nums[high] = temp;
		return i+1;
	}
}
