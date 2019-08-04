package leetcode;

public class NumberOfIsland {
	public int numIslands(char[][] grid) {
		int rows = grid.length;
		if(rows==0) {
			return 0;
		}
		int columns = grid[0].length;
		int ans = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == '1') {
					ans++;
					searchBorder(grid, i, j);
				}
			}
		}
		return ans;
	}

	public void searchBorder(char[][] grid, int r_pos, int c_pos) {
		int rows = grid.length;
		int columns = grid[0].length;
		if (r_pos < 0 || r_pos >= rows || c_pos < 0 || c_pos >= columns||grid[r_pos][c_pos]!='1') {
			return;
		}
		grid[r_pos][c_pos] = '2';
		searchBorder(grid, r_pos - 1, c_pos);
		searchBorder(grid, r_pos + 1, c_pos);
		searchBorder(grid, r_pos, c_pos - 1);
		searchBorder(grid, r_pos, c_pos + 1);
	}

	public static void main(String[] args) {
		NumberOfIsland ni = new NumberOfIsland();
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, 
									   { '1', '1', '0', '1', '0' }, 
									   { '1', '1', '0', '0', '0'},
									   { '0', '0', '0', '0', '0'}};
		System.out.println(ni.numIslands(grid));
	}
}
