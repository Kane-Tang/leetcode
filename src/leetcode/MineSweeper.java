package leetcode;

public class MineSweeper {

	public MineSweeper() {
		// TODO Auto-generated constructor stub
	}

	public char[][] updateBoard(char[][] board, int[] click) {
		int row = board.length;
		int col = board[0].length;
		int r = click[0];
		int c = click[1];
		if(board[r][c] == 'M') {
			board[r][c] = 'X';
		}else if(board[r][c] == 'E') {
			//recursive
			//dfs
			int count = 0;
			//surround board[r][c]
			for(int i=-1;i<=1;i++) {
				for(int j=-1;j<=1;j++) {
					if(i==0 && j==0) {
						continue;
					}
					int cr = i+r;
					int cc = j+c;
					if(cr<0 || cr>=row || cc<0 || cc>=col) {
						continue;
					}
					if(board[cr][cc] == 'X' || board[cr][cc] == 'M') {
						count++;
					}
				}
			}
			
			if(count > 0) {
				board[r][c] = (char)(count+'0');
			}else {
				board[r][c] = 'B';
				for(int i=-1;i<=1;i++) {
					for(int j=-1;j<=1;j++) {
						if(i==0 && j==0) {
							continue;
						}
						int cr = i+r;
						int cc = j+c;
						if(cr<0 || cr>=row || cc<0 || cc>=col) {
							continue;
						}
						if(board[cr][cc] == 'E') {
							updateBoard(board, new int[] {cr, cc});
						}
					}
				}
			}
		}
		return board;
	}
}
