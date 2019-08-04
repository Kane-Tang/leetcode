package leetcode;

public class SearchPosition {
	public int[] searchRange(int[] nums, int target) {
		int[] ans = new int[] {-1,-1};
		int l = nums.length;
		if(l==0) {
			return ans;
		}
		int left=0;
		int right=l;
		while(left<right) {//find the most left, which means when n[index]=target, we still need to go left
			int index=(left+right)/2;
			if(nums[index]==target||nums[index]>target) {
				right=index;
			}else {
				left=index+1;
			}
		}
		if(left>=l) {
			return ans;
		}
		if(nums[left]==target) {
			ans[0]=left;
		}
		if(ans[0]==-1) {
			return ans;
		}
		left=0;
		right=l;
		while(left<right) {//opposite to the above, where when n[index]=target, we need to go right
			int index=(left+right)/2;
			if(nums[index]>target) {
				right=index;
			}else {
				left=index+1;
			}
		}
		ans[1]=left-1;
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[]{2,2};
		SearchPosition sp = new SearchPosition();
		int[] ans = sp.searchRange(nums, 3);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
}
