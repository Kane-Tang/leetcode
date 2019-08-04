package leetcode;

public class StockSell {
	public int maxProfit(int[] prices) {
		int days = prices.length;
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<days;i++) {
			if(prices[i]<min) {
				min = prices[i];
			}
			else if(prices[i]-min>max) {
				max = prices[i]-min;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] prices = new int[] {7,6,4,3,1};
		StockSell ss = new StockSell();
		System.out.println(ss.maxProfit(prices));
	}
}
