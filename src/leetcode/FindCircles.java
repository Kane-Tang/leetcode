package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindCircles {

	public FindCircles() {
		// TODO Auto-generated constructor stub
	}

	public int findCircleNum(int[][] M) {
		int rows = M.length;
		int cols = M[0].length;
		int[] visit = new int[rows];
		int ans = 0;
		//dfs
		for(int i=0;i<rows;i++) {
			if(visit[i]==0) {
				dfs(M, visit, i);
				ans++;
			}
		}
		return ans;
	}
	
	public void dfs(int[][] M, int[] visit, int i) {
		for(int j=0;j<M.length;j++) {
			if(M[i][j] == 1 && visit[j] == 0) {
				visit[j] = 1;
				dfs(M, visit, j);
			}
		}
	}
}
