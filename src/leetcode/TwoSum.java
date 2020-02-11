package leetcode;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		//brute force
//		int l = numbers.length;
//		int[] ans = new int[2];
//		for(int i=0;i<l;i++) {
//			for(int j=i+1;j<l;j++) {
//				if(numbers[i]>target) {
//					return ans;
//				}
//				if(numbers[i]+numbers[j]>target) {
//					continue;
//				}
//				if(numbers[i]+numbers[j]==target) {
//					ans[0]=i+1;
//					ans[1]=j+1;
//				}
//			}
//		}
//		return ans;
		
		//dp
		int l =numbers.length;
		int[] ans = new int[2];
		int left = 0;
		int right = l-1;
		while(left<right) {
			if(numbers[left]+numbers[right]==target) {
				ans[0]=left+1;
				ans[1]=right+1;
				break;
			}
			
			if(numbers[left]+numbers[right]<target) {
				left++;
			}
			if(numbers[left]+numbers[right]>target) {
				right--;
			}
		}
		return ans;
	}
}
