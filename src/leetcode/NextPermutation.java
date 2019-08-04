package leetcode;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int length = nums.length;
		int i=length-2;
		for(i=length-2;i>=0;i--) {
			if(nums[i]<nums[i+1]) {
				break;
			}else {
				continue;
			}
		}
		if(i>=0) {
			int j = length - 1;
			for (j = length - 1; j >= 0; j--) {
				if (nums[j] > nums[i]) {
					break;
				} else {
					continue;
				}
			}
			System.out.println(i);
			System.out.println(j);
			swap(nums,i,j);
		}

		
		reverse(nums,i+1);
	}
	public void swap(int[] nums, int i,int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public void reverse(int[] nums,int point) {
		int i = point, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
	}
	
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = new int[] {1,1,5};
		np.nextPermutation(nums);
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]);
		}
	}
	
}
