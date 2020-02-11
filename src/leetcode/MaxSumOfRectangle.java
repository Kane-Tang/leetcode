package leetcode;

public class MaxSumOfRectangle {

	public MaxSumOfRectangle() {
		// TODO Auto-generated constructor stub
	}

	public int maxSumSubmatrix(int[][] matrix, int k) {
		// brute force
		int row = matrix.length;
		if (row == 0) {
			return 0;
		}
		int col = matrix[0].length;
		if (col == 0) {
			return 0;
		}

		int[][] areas = new int[row][col];// calculate all the area where i,j is bottom-right by adjacent rectangle
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int area = matrix[i][j];
				if (i - 1 >= 0) {
					area += areas[i - 1][j];
				}
				if (j - 1 >= 0) {
					area += areas[i][j - 1];
				}
				if (i - 1 >= 0 && j - 1 >= 0) {
					area -= areas[i - 1][j - 1];
				}
				areas[i][j] = area;
			}
		}

		int max = Integer.MIN_VALUE;
		// calculate all possible rectangles
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				for (int r = i; r < row; r++) {
					for (int c = j; c < col; c++) {
						int area = areas[r][c];
						if (i - 1 >= 0) {
							area -= areas[i - 1][c];
						}
						if (j - 1 >= 0) {
							area -= areas[r][j - 1];
						}
						if (i - 1 >= 0 && j - 1 >= 0) {
							area += areas[i - 1][j - 1];
						}
						//make the current rectangle with ij as top-left and rc as bottom-right
						if (area <= k) {
							max = Math.max(max, area);
						}
					}
				}
			}
		}
		return max;
	}
}
