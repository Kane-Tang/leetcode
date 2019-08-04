package leetcode;

public class Permutation {
	public String getPermutation(int n, int k) {
		int[] array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] = i+1;
		}
		String[] p = buildPermutation(n);
		String ans="";
		return ans;
	}
	public String[] buildPermutation(int n) {
		String[] p = new String[] {"1"};
		return p;
	}
}
