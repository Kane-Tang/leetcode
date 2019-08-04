package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloseToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		int l = points.length;
		int[][] ans = new int[l][2];
		if (l == 0) {
			return ans;
		}
		int[] d = new int[l];
		for (int i = 0; i < l; i++) {
			d[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
		}
		quickSort(d, 0, l - 1);
		int min = -1;
		int count = 0;
		int target = -1;
		for (int i = 0; i < l; i++) {
			if (d[i] > min) {
				count++;
				if (count == K) {
					target = d[i];
					break;
				}
			}
		}
		int j = 0;
		for (int i = 0; i < l; i++) {
			if (points[i][0] * points[i][0] + points[i][1] * points[i][1] <= target) {
				ans[j][0] = points[i][0];
				ans[j][1] = points[i][1];
				j++;
			}
		}
		int[][] res = new int[j][2];
		for(int i = 0;i<j;i++) {
			res[i][0] = ans[i][0];
			res[i][1] = ans[i][1];
		}
		return res;
	}

	public void quickSort(int[] nums, int low, int high) {
		if (low < high) {
			int par = partition(nums, low, high);
			quickSort(nums, low, par - 1);
			quickSort(nums, par + 1, high);
		}

	}

	public int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (nums[j] < pivot) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[i + 1];
		nums[i + 1] = nums[high];
		nums[high] = temp;
		return i + 1;
	}
}
