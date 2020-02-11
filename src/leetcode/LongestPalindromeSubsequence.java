package leetcode;

public class LongestPalindromeSubsequence {

	public LongestPalindromeSubsequence() {
		// TODO Auto-generated constructor stub
	}

	public int longestPalindromeSubseq(String s) {
		int l = s.length();
		int[][] dp = new int[l][l];
		for(int i=0;i<l;i++) {
			dp[i][i] = 1;
			for(int j=i-1;j>=0;j--) {
				if(s.charAt(j) == s.charAt(i)) {
					dp[j][i] = dp[j+1][i-1]+2;
				}else {
					dp[j][i] = Math.max(dp[j+1][i], dp[j][i-1]);
				}
			}
		}
		return dp[0][l-1];
	}
}
