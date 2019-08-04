package leetcode;

public class MinPath {
	public int minPathSum(int[][] grid) {
		int rows = grid.length;
		int col = grid[0].length;
		int[][] pathCost = new int[rows][col];
		//initialization
		for(int i=rows-1;i>=0;i--) {
			for(int j=col-1;j>=0;j--) {
				if(i==rows-1) {
					if(j==col-1) {
						pathCost[i][j] = grid[i][j];
					}
					else {
						pathCost[i][j] = pathCost[i][j+1]+grid[i][j];
					}
				}
				if(j==col-1) {
					if(i==rows-1) {
						pathCost[i][j] = grid[i][j];
					}
					else {
						pathCost[i][j] = pathCost[i+1][j]+grid[i][j];
					}
				}
			}
		}
		for(int i=rows-2;i>=0;i--) {
			for(int j=col-2;j>=0;j--) {
				pathCost[i][j] = Math.min(pathCost[i+1][j]+grid[i][j], pathCost[i][j+1]+grid[i][j]);
			}
		}
		int ans = pathCost[0][0];
		return ans;
	}
	
//	public int getRes(int[][] grid,int x,int y) {
//		if(x==grid.length-1) {
//			int ans = 0;
//			for(int i=y;i<grid[0].length;i++) {
//				ans+=grid[x][i];
//			}
//			return ans;
//		}
//		if(y==grid[0].length-1) {
//			int ans = 0;
//			for(int i=x;i<grid.length;i++) {
//				ans+=grid[i][y];
//			}
//			return ans;
//		}
//		return Math.min(getRes(grid,x+1,y)+grid[x][y], getRes(grid,x,y+1)+grid[x][y]);
//	}
	
	public static void main(String[] args) {
		MinPath mp = new MinPath();
		int[][] grid = new int[][] {{1,3,1},
									{1,5,1},
									{4,2,1}};
		System.out.println(mp.minPathSum(grid));
	}
}
