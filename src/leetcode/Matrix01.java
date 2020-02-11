package leetcode;

public class Matrix01 {

	public Matrix01() {
		// TODO Auto-generated constructor stub
	}

	public int[][] updateMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] output = new int[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(matrix[i][j] == 0) {
					output[i][j] = 0;
				}else {
					int min = Integer.MAX_VALUE-100;
					if(i-1 >= 0) {
						min = Math.min(min, output[i-1][j]+1);
					}
					if(j-1 >= 0) {
						min = Math.min(min, output[i][j-1]+1);
					}
					output[i][j] = min;
				}
			}
		}
		for(int i=row-1;i>=0;i--) {
			for(int j=col-1;j>=0;j--) {
				if(matrix[i][j] == 0) {
					output[i][j] = 0;
				}else {
					int min = output[i][j];
					if(i+1 < row) {
						min = Math.min(min, output[i+1][j]+1);
					}
					if(j+1 < col) {
						min = Math.min(output[i][j+1]+1, min);
					}
					output[i][j] = min;
				}
			}
		}
		return output;
	}
}
