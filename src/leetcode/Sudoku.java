package leetcode;

public class Sudoku {
	public boolean isValidSudoku(char[][] board) {
		int rows = 9;
		int columns = 9;
		int[] check = new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < rows; i++) {// line check
			for (int p = 0; p < check.length; p++) {
				check[p] = 0;
			}
			for (int j = 0; j < columns; j++) {
				if (board[i][j] < '1' || board[i][j] > '9') {
					continue;
				}
				check[Character.getNumericValue(board[i][j])] += 1;
			}
			for (int q = 0; q < check.length; q++) {
				if (check[q] > 1) {
					return false;
				}
			}
		}
		for (int j = 0; j < columns; j++) {// column check
			for (int p = 0; p < check.length; p++) {
				check[p] = 0;
			}
			for (int i = 0; i < rows; i++) {
				if (board[i][j] < '1' || board[i][j] > '9') {
					continue;
				}
				check[Character.getNumericValue(board[i][j])] += 1;
			}
			for (int q = 0; q < check.length; q++) {
				if (check[q] > 1) {
					return false;
				}
			}
		}
		// subsquare check
		int rowCount=0;
		int columnCount=0;
		int count=0;
		while(rowCount<3&&columnCount<3) {
			System.out.print(rowCount);
			System.out.println(columnCount);
			for (int p = 0; p < check.length; p++) {
				check[p] = 0;
			}
			for (int i = rowCount*3; i < rowCount*3+3; i++) {
				for (int j = columnCount*3; j < columnCount*3+3; j++) {
					if (board[i][j] < '1' || board[i][j] > '9') {
						continue;
					}
					check[Character.getNumericValue(board[i][j])] += 1;
				}
			}
			count++;
			columnCount++;
			if(count%3==0) {
				rowCount++;
				columnCount=0;
			}
			for(int q=0;q<check.length;q++) {
				if(check[q]>1) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { 
				{ '.', '.', '4', '.', '.', '.', '6', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '.', '7', '9' }, };
		Sudoku s = new Sudoku();
		System.out.println(s.isValidSudoku(board));
	}
}
