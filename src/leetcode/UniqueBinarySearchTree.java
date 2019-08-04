package leetcode;

public class UniqueBinarySearchTree {
	public int numTrees(int n) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		
		int[] G = new int[n + 1];
	    G[0] = 1;
	    G[1] = 1;

	    for (int i = 2; i <= n; ++i) {//number of nodes
	      for (int j = 1; j <= i; ++j) {//index of root
	        G[i] += G[j - 1] * G[i - j];//each time take jth as the root, calculate its left child tree and right child tree
	      }
	    }
	    return G[n];
	}
	
	
	public static void main(String[] args) {
		UniqueBinarySearchTree ubst = new UniqueBinarySearchTree();
		System.out.println(ubst.numTrees(3));
	}
}
