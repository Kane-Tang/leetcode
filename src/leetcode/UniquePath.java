package leetcode;

public class UniquePath {
	public int uniquePaths(int m, int n) {
//		if(m==1||n==1) {
//			return 1;
//		}
//		return uniquePaths(m-1,n)+uniquePaths(m,n-1);
		int[][] path = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0) {
					path[i][j] = 0;
				}
				if(i==1||j==1) {
					path[i][j] = 1;
				}
			}
		}
		for(int i=2;i<=m;i++) {
			for(int j=2;j<=n;j++) {
				path[i][j] = path[i-1][j]+path[i][j-1];
			}
		}
		return path[m][n];
	}
	
	public static void main(String[] args) {
		UniquePath up = new UniquePath();
		System.out.println(up.uniquePaths(7, 3));
	}
}
