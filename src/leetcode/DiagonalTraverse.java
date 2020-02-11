package leetcode;

public class DiagonalTraverse {

	public DiagonalTraverse() {
		// TODO Auto-generated constructor stub
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		int row = matrix.length;
		if(row == 0) {
			return new int[0];
		}
		int col = matrix[0].length;
		int i=0;
		int j=0;
		int[] ans = new int[row*col];
		int p = 0;
		int dir = 1;
		while(i<row && j<col) {
			ans[p] = matrix[i][j];
			p++;
			//move to top right
			if(dir == 1) {
				//top-right, i--, j++
				if(i-1>=0 && j+1<col) {
					i--;
					j++;
				}else if(j+1 < col) {
					j++;
					dir = 0;
				}else {
					i++;
					dir = 0;
				}
			}else {
				//bottom-left, i++, j--
				if(i+1 >= row) {
					j++;
					dir = 1;
				}else if(j-1 < 0) {
					i++;
					dir = 1;
				}else {
					i++;
					j--;
				}
			}
		}
		return ans;
	}
}
