package leetcode;

public class Bag01 {
	//expression: f[i][v] = max(f[i-1][v], f[i-1][v-c[i]]+w[i])
	public void bag(int[] c, int[] w, int n, int v) {
		int[][] f = new int[n+1][v+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=v;j++) {
				if(w[j]>j) {
					//the volumn of the current item is larger than the bag's
					f[i][v] = f[i-1][v];
				}else {
					//check whether we should put the ith item into the bag
					f[i][v] = Math.max(f[i-1][v], f[i-1][v-c[i]]+w[i]);
				}
			}
		}
	}
}
