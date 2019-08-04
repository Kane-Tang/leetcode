package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
	public int trap(int[] height) {
//		int ans = 0;
//		int size = height.length;
//		for (int i = 1; i < size - 1; i++) {
//			int max_left = 0, max_right = 0;
//			for (int j = i; j >= 0; j--) { // Search the left part for max bar size
//				max_left = Math.max(max_left, height[j]);
//			}
//			for (int j = i; j < size; j++) { // Search the right part for max bar size
//				max_right = Math.max(max_right, height[j]);
//			}
//			ans += Math.min(max_left, max_right) - height[i];
//		}
//		return ans;
		int l = height.length;
		int ans = 0;
		if (l < 2) {
			return 0;
		}
		int[] l_bar = new int[l];
		int[] r_bar = new int[l];
		l_bar[0] = height[0];
		for(int i=1;i<l;i++) {
			l_bar[i] = Math.max(height[i], l_bar[i-1]);
		}
		r_bar[l-1] = height[l-1];
		for(int i = l-2;i>=0;i--) {
			r_bar[i] = Math.max(height[i], r_bar[i+1]);
		}
		for(int i=1;i<=l-2;i++) {
			ans += Math.min(l_bar[i], r_bar[i])-height[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trw.trap(height));
	}
}
