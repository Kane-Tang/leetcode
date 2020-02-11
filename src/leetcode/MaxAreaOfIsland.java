package leetcode;

public class MaxAreaOfIsland {

	public MaxAreaOfIsland() {
		// TODO Auto-generated constructor stub
	}
	
	public int maxAreaOfIsland(int[][] grid) {
		//dfs
		int row = grid.length;
		int col = grid[0].length;
		int max = 0;
		boolean[][] visit = new boolean[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				max = Math.max(max, findArea(grid, visit, i, j));
			}
		}
		return max;
	}
	
	public int findArea(int[][] grid, boolean[][] visit, int r, int c) {
		if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0 || visit[r][c]) {
			return 0;
		}
		visit[r][c] = true;//make sure the search won't go infinity cycle
		return 1+findArea(grid, visit, r-1, c)+findArea(grid, visit, r+1, c)
			+findArea(grid, visit, r, c-1)+findArea(grid, visit, r, c+1);
	}
}
