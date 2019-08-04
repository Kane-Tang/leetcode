package leetcode;

public class MaximalSquare {
//	public int maximalSquare(char[][] matrix) {
//		int m = matrix.length;
//		if(m==0){
//            return 0;
//        }
//		int n = matrix[0].length;
//		int ans = 0;
//		for(int i=0;i<m;i++) {
//			for(int j=0;j<n;j++) {//check each point as the top-left one
//				if(matrix[i][j] == '1') {
//					boolean flag = true;
//					int length = 1;
//					while(length+i<m && length+j<n && flag==true) {//under the limit and there's no 0
//						//only need to check the outer layer
//						for(int q = i;q<=length+i;q++) {
//							if(matrix[q][length+j] == '0') {
//								flag = false;
//								break;
//							}
//						}
//						
//						for(int q = j;q<=length+j;q++) {
//							if(matrix[length+i][q] == '0') {
//								flag = false;
//								break;
//							}
//						}
//						
//						if(flag) {
//							length++;
//						}
//						
//					}
//					if(length>ans) {
//						ans = length;
//					}
//				}
//			}
//		}
//		
//		return ans*ans;
//	}

	public int maximalSquare(char[][] matrix) {
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        //dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell with index (i,j) in the original matrix.
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
	}
}
