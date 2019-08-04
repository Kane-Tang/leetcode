package leetcode;

public class MedianOfArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int i = 0;
		int j = 0;
		int index = 0;
		int l = l1+l2;
		double ans = 0.0;
		
		if(l1==0) {//l1 is empty
			if(l2%2==0) {
				return (double)(nums2[l2/2]+nums2[l2/2-1])/2;
			}else {
				return (double)nums2[l2/2];
			}
		}
		
		if(l2==0) {
			if(l1%2==0) {
				return (double)(nums1[l1/2]+nums1[l1/2-1])/2;
			}else {
				return (double)nums1[l1/2];
			}
		}
		while(index<(l1+l2)/2) {
			if(i>=l1) {
				j++;
				index++;
				continue;
			}
			
			if(j>=l2) {
				i++;
				index++;
				continue;
			}
			
			if(nums1[i]<nums2[j]) {
				i++;
				index++;
			}else {
				j++;
				index++;
			}
		}
		if(l%2==0) {
			int p1 = 0;
			int p2 = 0;

			if(i==l1) {
				p1 = nums2[j];
			}else if(j==l2){
				p1 = nums1[i];
			}else if(nums1[i]<nums2[j]) {
				p1 = nums1[i];
			}else if(nums1[i]>=nums2[j]){
				p1 = nums2[j];
			}else {
				
			}
			
			if(i==0) {
				p2 = nums2[j-1];
			}else if(j==0) {
				p2 = nums1[i-1];
			}else if(nums1[i-1]<nums2[j-1]) {
				p2 = nums2[j-1];
			}else if(nums1[i-1]>=nums2[j-1]){
				p2 = nums1[i-1];
			}else {
				
			}
			ans = (double)(p1+p2)/2;
			
		}else {
			if(i<0||i>=l1) {
				ans = nums2[j];
				return ans;
			}
			if(j<0||j>=l2) {
				ans = nums1[i];
				return ans;
			}
			if(nums1[i]<nums2[j]) {
				ans = nums1[i];
			}else {
				ans = nums2[j];
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		MedianOfArray moa = new MedianOfArray();
		int[] nums2 = new int[] {1,2};
		int[] nums1 = new int[] {1,2};
		System.out.println(moa.findMedianSortedArrays(nums1, nums2));
	}
}
