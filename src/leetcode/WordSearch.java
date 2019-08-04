package leetcode;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		int index = 0;
		boolean ans = false;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]==word.charAt(index)) {
					if(findAns(board, i, j, word, index)) {
						return true;
					}
				}
			}
		}
		return ans;
	}
	
	public boolean findAns(char[][] board, int i, int j, String word, int index) {
		//recursion
		if(index>=word.length()) {
			return true;//find the match of the last character
		}
		
		if(i<0 || j<0 || i>=board.length || j>=board[0].length) {
			return false;//out of bound
		}
		
		if(board[i][j]!=word.charAt(index)) {
			return false;
		}
		char temp = board[i][j];
		board[i][j] = '0';//already passed
		
		if(findAns(board, i-1, j, word, index+1) || findAns(board, i+1, j, word, index+1)
				|| findAns(board, i, j-1, word, index+1) || findAns(board, i, j+1, word, index+1)) {
			return true;
		}
		
		board[i][j] = temp;//recover for next matching process
		return false;
	}
}
