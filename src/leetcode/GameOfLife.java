package leetcode;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int[][] neighbour = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				int tmp = 0;
				//left-top
				if(i-1>=0 && j-1>=0) {
					if(board[i-1][j-1]==1) {
						tmp++;
					}
				}
				//top
				if(i-1>=0) {
					if(board[i-1][j]==1) {
						tmp++;
					}
				}
				//right-top
				if(i-1>=0 && j+1<n) {
					if(board[i-1][j+1]==1) {
						tmp++;
					}
				}
				//left
				if(j-1>=0) {
					if(board[i][j-1]==1) {
						tmp++;
					}
				}
				//right
				if(j+1<n) {
					if(board[i][j+1]==1) {
						tmp++;
					}
				}
				//left-down
				if(i+1<m && j-1>=0) {
					if(board[i+1][j-1]==1) {
						tmp++;
					}
				}
				//down
				if(i+1<m) {
					if(board[i+1][j]==1) {
						tmp++;
					}
				}
				//right-down
				if(i+1<m && j+1<n) {
					if(board[i+1][j+1]==1) {
						tmp++;;
					}
				}
				
				if(board[i][j]==1) {//live cell
					if(tmp<2) {
						neighbour[i][j]=0;
						continue;
					}
					if(tmp>=2 && tmp<=3) {
						neighbour[i][j]=1;
						continue;
					}
					if(tmp>3) {
						neighbour[i][j]=0;
						continue;
					}
				}
				
				if(board[i][j]==0) {//dead cell
					if(tmp==3) {
						neighbour[i][j]=1;
					}
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = neighbour[i][j];
			}
		}
	}
}
