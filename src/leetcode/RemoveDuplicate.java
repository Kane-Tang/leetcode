package leetcode;

public class RemoveDuplicate {
	public int removeDuplicates(int[] nums) {
		int length = nums.length;
		if(length == 0) {
			return 0;
		}
		int ans = 1;
		int tmp = nums[0];
		for(int i=1;i<length;i++) {
			if(nums[i] != tmp) {
				nums[ans] = nums[i];
				ans++;
			}
			tmp = nums[i];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		RemoveDuplicate rd = new RemoveDuplicate();
		int[] input = new int[] {0,0,1,1,1,2,2,3,3,4};
		System.out.println(rd.removeDuplicates(input));
	}
}
