package leetcode;

public class EditDistance {

	public EditDistance() {
		// TODO Auto-generated constructor stub
	}

	public int minDistance(String word1, String word2) {
		int l1 = word1.length();
		int l2 = word2.length();
		if(l1==0 && l2==0) {
			return 0;
		}else if(l1 == 0) {
			return l2;
		}else if(l2 == 0) {
			return l1;
		}else {
			int[][] dp = new int[l1+1][l2+1];
			dp[0][0] = 0;
			for(int i=0;i<=l1;i++) {
				dp[i][0] = i;
			}
			for(int j=0;j<=l2;j++) {
				dp[0][j] = j;
			}
			for(int i=1;i<=l1;i++) {
				for(int j=1;j<=l2;j++) {
					/*the first i in word1 and first j in word2*/
					int left = dp[i - 1][j] + 1;
			        int down = dp[i][j - 1] + 1;
			        int left_down = dp[i - 1][j - 1];
			        if (word1.charAt(i - 1) != word2.charAt(j - 1))
			          left_down += 1;
			        dp[i][j] = Math.min(left, Math.min(down, left_down));
				}
			}
			return dp[l1][l2];
		}
	}
}
