package leetcode;

public class SortColor {
	public void sortColors(int[] nums) {
		//quickSort(nums, 0, nums.length-1);
		mergeSort(nums, 0, nums.length-1);
	}
	
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
	
	public void mergeSort(int[] nums, int low, int high) {
		if(low<high) {
			int median = (low + high) / 2;
			mergeSort(nums, low, median);
			mergeSort(nums, median + 1, high);
			merge(nums, low, median, high);
		}
	}
	
	public void merge(int[] nums, int low, int median, int high) {
		int l1 = median-low+1;
		int l2 = high - median;
		int[] n1 = new int[l1];
		int[] n2 = new int[l2];
		for(int i=0;i<l1;i++) {
			n1[i] = nums[low+i];
		}
		for(int i=0;i<l2;i++) {
			n2[i] = nums[median+1+i];
		}
		
		//merge n1&n2
		int i=0;
		int j=0;
		int k = low;
		while(i<l1 && j<l2) {
			if(n1[i]<=n2[j]) {
				nums[k] = n1[i];
				i++;
			}else {
				nums[k] = n2[j];
				j++;
			}
			k++;
		}
		//the remaining entries
		while(i<l1) {
			nums[k] = n1[i];
			i++;
			k++;
		}
		while(j<l2) {
			nums[k] = n2[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,0,2,1,1,0};
		SortColor sc = new SortColor();
		sc.sortColors(nums);
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]);
		}
	}
}
