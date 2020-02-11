package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StockSellThree {

	public int maxProfit(int[] prices) {
	    if (prices == null || prices.length < 2) {
	        return 0;
	    }
	    return constantSpaceDP(prices);
	    //return nSpaceDP(prices);
	    //return mnSpaceDP(prices);
	}

	/*
	sell2[i]: max profit when have sold upon p[i], total transaction is 2
	buy2[i]: max profit when have bought upon p[i], total transaction is 2
	sell1[i]: max profit when have sold upon p[i], total transaction is 1
	buy1[i]: max profit when have bought upon p[i], total transaction is 1

	sell2[i] = max(sell2[i - 1], buy2[i - 1] + p[i])
	buy2[i] = max(buy2[i - 1], sell1[i - 1] - p[i]),buy2 depends on previous sell1

	sell1[i] = max(sell1[i - 1], buy1[i - 1] + p[i])
	buy1[i] = max(buy1[i - 1], -p[i])

	optimization: space O(4n) -> O(4)
	*/   

	private int constantSpaceDP(int[] p) {
	    int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
	    for (int tp : p) {
	        sell2 = Math.max(sell2, buy2 + tp);
	        buy2 = Math.max(buy2, sell1 - tp);
	        sell1 = Math.max(sell1, buy1 + tp);
	        buy1 = Math.max(buy1, -tp);
	        System.out.println(buy1+" "+sell1+" "+buy2+" "+sell2);
	    }
	    return Math.max(sell1, sell2);
	}

	/*
	M[i][j]: max profit of i-th transaction from day 0 to day j
	M[i][j] = max(M[i][j - 1], max(M[i - 1][k] + p[j] - p[k])), k from 0 to j - 1
	        = max(M[i][j - 1], p[j] + max(M[i - 1][k] - p[k]))
	        = max(M[i][j - 1], p[j] + tmp);
	    tmp = Math.max(tmp, M[i - 1][j] - p[j]);
	optimization: space O(m*n) -> O(n)
	*/

	private int nSpaceDP(int[] p) {
	    int[] M = new int[p.length];
	    for (int i = 1; i < 3; i++) {
	        int tmp = M[0] - p[0], top;
	        for (int j = 1; j < p.length; j++) {
	            top = M[j];
	            M[j] = Math.max(M[j - 1], tmp + p[j]);
	            tmp = Math.max(tmp, top - p[j]);
	        }
	    }
	    return M[p.length - 1];
	}

	private int mnSpaceDP(int[] p) {
	    int[][] M = new int[3][p.length];
	    for (int i = 1; i < 3; i++) {
	        int tmp = M[i - 1][0] - p[0];
	        for (int j = 1; j < p.length; j++) {
	            M[i][j] = Math.max(M[i][j - 1], tmp + p[j]);
	            tmp = Math.max(tmp, M[i - 1][j] - p[j]);
	        }
	    }
	    return M[2][p.length - 1];
	}
}
