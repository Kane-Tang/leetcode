package leetcode;

public class RottingOranges {

	public RottingOranges() {
		// TODO Auto-generated constructor stub
	}

	public int orangesRotting(int[][] grid) {
        //brute force
		int rows = grid.length;
		int cols = grid[0].length;
		int times = 0;
		while(true) {
			int[][] newGrid = new int[rows][cols];
			boolean flag = false;
			for(int i=0;i<rows;i++) {
				for(int j=0;j<cols;j++) {
					if(i>0&&grid[i-1][j]==2 || 
							i<rows-1&&grid[i+1][j]==2 ||
							j>0&&grid[i][j-1]==2 ||
							j<cols-1&&grid[i][j+1]==2) {
						if(grid[i][j]==1) {
							newGrid[i][j] = 2;
						}else {
							newGrid[i][j] = grid[i][j];
						}
					}else {
						newGrid[i][j] = grid[i][j];
					}
					if(newGrid[i][j] != grid[i][j]) {
						flag = true;
					}
				}
			}
			grid = newGrid;
			if(flag == false) {
				for(int i=0;i<rows;i++) {
					for(int j=0;j<cols;j++) {
						if(grid[i][j]==1) {
							times = -1;
							break;
						}
					}
				}
				break;
			}
			times++;
		}
		return times;
    }
}
