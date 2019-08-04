package leetcode;

public class SearchInMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		if(rows==0) {
			return false;
		}
		int columns = matrix[0].length;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				if(j==0) {
					if(matrix[i][j]>target) {
						return false;
					}
				}
				if(matrix[i][j]>target) {
					break;
				}
				if(matrix[i][j]==target) {
					return true;
				}
				
			}
		}
		return false;
	}
}
