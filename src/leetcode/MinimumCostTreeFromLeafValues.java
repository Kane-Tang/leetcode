package leetcode;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {

	public MinimumCostTreeFromLeafValues() {
		// TODO Auto-generated constructor stub
	}

	public int mctFromLeafValues(int[] arr) {
		//dynamic programming
		int l = arr.length;
		int[][] dp = new int[l][l];
		int[][] max = new int[l][l];
		for(int i=0;i<l;i++) {
			int local = 0;
			for(int j=i;j<l;j++) {
				if(arr[j] > local) {
					local = arr[j];
				}
				max[i][j] = local;
			}
		}
		
		for(int i=1;i<l;i++) {
			for(int left=0;left+i<l;left++) {
				int right = left+i;
				dp[left][right] = Integer.MAX_VALUE;
				if(i==1) {
					dp[left][right] = arr[left]*arr[right];
				}else {
					for(int k=left;k<right;k++) {
						dp[left][right] = Math.min(dp[left][right], 
								dp[left][k]+dp[k+1][right]+max[left][k]*max[k+1][right]);
					}
				}
			}
		}
		//return dp[0][l-1];
		
		//better solution without dp
		int res = 0;
		Stack<Integer> stack = new Stack();
		stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
	}
}
