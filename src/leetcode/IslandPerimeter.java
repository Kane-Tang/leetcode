package leetcode;

public class IslandPerimeter {

	public IslandPerimeter() {
		// TODO Auto-generated constructor stub
	}

	public int islandPerimeter(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		int ans = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(grid[i][j]==1) {
					int edge = 4;
					if(i-1>=0 && grid[i-1][j]==1) {
						edge -= 1;
					}
					if(i+1<r && grid[i+1][j]==1) {
						edge -= 1;
					}
					if(j-1>=0 && grid[i][j-1]==1) {
						edge -= 1;
					}
					if(j+1<c && grid[i][j+1]==1) {
						edge -= 1;
					}
					ans += edge;
				}
			}
		}
		return ans;
	}
}
