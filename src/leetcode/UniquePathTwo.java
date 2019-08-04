package leetcode;

public class UniquePathTwo {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int ans = 0;
		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;
		if(obstacleGrid[0][0] == 1) {
			return 0;
		}
		int[][] output = new int[rows][columns];
		output[0][0] = 1;
		for(int i=1;i<rows;i++) {
			if(obstacleGrid[i][0]==0 && output[i-1][0]==1) {
				output[i][0] = 1;
			}
			else {
				output[i][0] = 0;
			}
		}
		for(int j=1;j<columns;j++) {
			if(obstacleGrid[0][j]==0 &&output[0][j-1]==1) {
				output[0][j] = 1;
			}
			else {
				output[0][j] = 0;
			}
		}
		for(int i=1;i<rows;i++) {
			for(int j=1;j<columns;j++) {
				if(obstacleGrid[i][j]==0) {
					output[i][j] = output[i-1][j]+output[i][j-1];
				}
				else {
					output[i][j] = 0;
				}
			}
		}
		return output[rows-1][columns-1];
	}
	
	public static void main(String[] args) {
		UniquePathTwo upt = new UniquePathTwo();
		int[][] grid = new int[][] {{0,0,0},
									{0,1,0},
									{0,0,0}};
		System.out.println(upt.uniquePathsWithObstacles(grid));							
	}
}
