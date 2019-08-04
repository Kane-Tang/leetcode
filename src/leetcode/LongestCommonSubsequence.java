package leetcode;

public class LongestCommonSubsequence {
	
	public void lcs(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] c = new int[l1+1][l2+1];
		
		//not continuous
		for(int i=0;i<=l1;i++) {
			for(int j=0;j<=l2;j++) {
				if(i==0 || j==0) {
					c[i][j] = 0;
				}else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					c[i][j] = c[i-1][j-1]+1;
				}else {
					c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
				}
			}
		}
		
		//continuous
		int result = 0;//the answer
		for(int i=0;i<=l1;i++) {
			for(int j=0;j<=l2;j++) {
				if(i==0 || j==0) {
					c[i][j] = 0;
				}else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					c[i][j] = c[i-1][j-1]+1;
					result = Math.max(result, c[i][j]);
				}else {
					c[i][j] = 0;
				}
			}
		}
	}
	
	
	
}
