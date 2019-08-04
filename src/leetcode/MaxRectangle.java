package leetcode;

import java.util.Arrays;

public class MaxRectangle {
//	public int maximalRectangle(char[][] matrix) {
//		int rows = matrix.length;
//        if(rows==0){
//            return 0;
//        }
//		int columns = matrix[0].length;
//		int[][] maxArea = new int[rows][columns];//rightbottomcorner
//		int ans = 0;
//		for(int i=0;i<rows;i++) {
//			if(matrix[i][0]=='1') {
//				maxArea[i][0] = 1;
//				int width = maxArea[i][0];
//				for(int q = i;q>=0;q--) {
//					width = Math.min(width, maxArea[q][0]);
//					int height = i-q+1;
//					ans = Math.max(ans, width*height);
//				}
//				
//			}
//			else {
//				maxArea[i][0] = 0;
//			}
//		}
//		for(int i=0;i<rows;i++) {
//			for(int j=1;j<columns;j++) {
//				if(matrix[i][j]=='1') {
//					maxArea[i][j] = maxArea[i][j-1]+1;
//					int width = maxArea[i][j];
//					for(int q = i;q>=0;q--) {
//						width = Math.min(width, maxArea[q][j]);
//						int height = i-q+1;
//						ans = Math.max(ans, width*height);
//					}
//				}
//			}
//		}
//		return ans;
//	}
	
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible
        int maxarea = 0;
        for(int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            // update left
            for(int j=0; j<n; j++) {
                if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur_left);
                else {left[j]=0; cur_left=j+1;}
            }
            // update right
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {right[j] = n; cur_right = j;}    
            }
            // update area
            for(int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }
	
	public static void main(String[] args) {
		
	}
}
