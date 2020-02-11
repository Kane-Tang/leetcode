package leetcode;

public class MinimumCostToMergeStones {

	public MinimumCostToMergeStones() {
		// TODO Auto-generated constructor stub
	}

	public int mergeStones(int[] stones, int K) {
		int l = stones.length;
		if ((l - 1) % (K - 1) != 0) {
            return -1;
        }
		int max = Integer.MAX_VALUE;
		// dp
		int[][][] dp = new int[l][l][K+1];// dp[i][j] = min(sum[i][j] + dp[i][k] + dp[k+1][j])
		for(int i=0;i<l;i++) {
			for(int j=0;j<l;j++) {
				for(int k=1;k<=K;k++) {
					dp[i][j][k] = max;
				}
			}
		}
		for(int i=0;i<l;i++) {
			dp[i][i][1] = 0;
		}
		// count sum first
		int[] prefixSum = new int[l];
		prefixSum[0] = stones[0];
		for (int i = 1; i < l; i++) {
			prefixSum[i] = prefixSum[i - 1] + stones[i];
		}
		for (int interval = 1; interval < l; interval++) {
			for (int i = 0; i < l - interval; i++) {
				int j = i+interval;
				int sum = 0;
				if(i>0) {
					sum = prefixSum[j] - prefixSum[i-1];
				}else {
					sum = prefixSum[j];
				}
				for(int k=2;k<=K;k++) {
					for(int q=i;q<j;q++) {
						if(dp[i][q][k-1] == max || dp[q+1][j][1] == max) {
							continue;
						}
						dp[i][j][k] = Math.min(dp[i][j][k], dp[i][q][k-1] + dp[q + 1][j][1]);
					}
				}
				if(dp[i][j][K] == max) {
					continue;
				}
				dp[i][j][1] = dp[i][j][K] + sum;
			}
		}
		return dp[0][l - 1][1];
	}
}
