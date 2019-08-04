package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new ArrayList();
		char[][] chess = new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				chess[i][j] = '.';
			}
		}
		dfs(chess, 0, ans);
		return ans;
 	}
	
	public void dfs(char[][] chess, int row, List<List<String>> ans) {
		if(row == chess.length) {
			ans.add(reshape(chess));
			return;
		}
		int columns = chess.length;
		for(int j = 0;j < columns;j++) {
			if(isValid(chess, row, j)) {
				chess[row][j] = 'Q';
				dfs(chess, row+1, ans);
				chess[row][j] = '.';
			}
			else {
				chess[row][j] = '.';
			}
		}
	}
	
	public boolean isValid(char[][] chess, int rowIndex, int colIndex) {
		for(int i=0;i<rowIndex;i++) {
			if(chess[i][colIndex] == 'Q') {
				return false;
			}
		}
		for(int j=0;j<chess.length;j++) {
			if(chess[rowIndex][j] == 'Q') {
				return false;
			}
		}
		int r = rowIndex-1;
		int c = colIndex-1;
		while(r>=0 && c>=0) {
			if(chess[r][c] == 'Q') {
				return false;
			}
			r--;
			c--;
		}
		
		r = rowIndex-1;
		c = colIndex+1;
		while(r>=0 && c<=chess.length-1) {
			if(chess[r][c] == 'Q') {
				return false;
			}
			r--;
			c++;
		}
		return true;
	}
	
	public List<String> reshape(char[][] chess){
		List<String> res = new ArrayList();
		int rows = chess.length;
		int columns = rows;
		for(int i=0;i<rows;i++) {
			StringBuilder s = new StringBuilder();
			for(int j=0;j<columns;j++) {
				s.append(chess[i][j]);
			}
			res.add(s.toString());
		}
		return res;
	}
	
	public static void main(String[] args) {
		NQueen nq = new NQueen();
		List<List<String>> ans = new ArrayList();
		ans = nq.solveNQueens(4);
		System.out.println(ans);
			
	}
}
