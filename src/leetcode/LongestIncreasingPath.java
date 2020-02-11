package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingPath {

	public LongestIncreasingPath() {
		// TODO Auto-generated constructor stub
	}
	public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return 0;
        }
        int col = matrix[0].length;
        int ans = 0;
        int[][] distance = new int[row][col];
        for(int i=0;i<row;i++) {
        	for(int j=0;j<col;j++) {
                int tmp = traverse(matrix, distance, i, j);
                ans = Math.max(ans, tmp);
        	}
        }
        return ans;
    }
	
	public int traverse(int[][] matrix, int[][] distance, int r, int c) {
		if(distance[r][c] != 0) {//already checked
			return distance[r][c];
		}
		//check left
		if(c-1 >=0 && matrix[r][c-1] > matrix[r][c]) {
			distance[r][c] = Math.max(distance[r][c], traverse(matrix, distance, r, c-1));
		}
		//check right
		if(c+1 < matrix[0].length && matrix[r][c+1] > matrix[r][c]) {
			distance[r][c] = Math.max(distance[r][c], traverse(matrix, distance, r,c+1));
		}
		//check top
		if(r-1 >=0 && matrix[r-1][c] > matrix[r][c]) {
			distance[r][c] = Math.max(distance[r][c], traverse(matrix, distance, r-1, c));
		}
		//check bot
		if(r+1 < matrix.length && matrix[r+1][c] > matrix[r][c]) {
			distance[r][c] = Math.max(distance[r][c], traverse(matrix, distance, r+1, c));
		}
		return ++distance[r][c];
	}
}
