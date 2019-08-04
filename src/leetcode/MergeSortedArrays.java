package leetcode;

public class MergeSortedArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] copy = new int[m];
		for(int i=0;i<m;i++) {
			copy[i] = nums1[i];
		}
		
		int i=0;
		int j=0;
		int pointer = 0;
		while(i<m && j<n) {
			int tmp1 = copy[i];
			int tmp2 = nums2[j];
			if(tmp1 <= tmp2) {
				nums1[pointer] = tmp1;
				i++;
				pointer++;
			}else {
				nums1[pointer] = tmp2;
				j++;
				pointer++;
			}
		}
		if(i==m) {
			for(int p=pointer;p<m+n;p++) {
				nums1[p] = nums2[j];
				j++;
			}
		}else if(j == n) {
			for(int p=pointer;p<m+n;p++) {
				nums1[p] = copy[i];
				i++;
			}
		}else {
			
		}
	}
}
