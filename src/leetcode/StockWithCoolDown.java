package leetcode;

public class StockWithCoolDown {

	public StockWithCoolDown() {
		// TODO Auto-generated constructor stub
	}

	public int maxProfit(int[] prices) {
		//with a cool down day
		int l = prices.length;
		//dp
		if(l==0){
            return 0;
        }
        if(l==1){
            return 0;
        }

        int[] buy = new int[l+1];//buy[i]: The maximum profit can be made if the first i days end with buy or wait. E.g "buy, sell, buy" or "buy, cooldown, cooldown"
        int[] sell = new int[l+1];//The maximum profit can be made if the first i days end with sell or wait. E.g "buy, sell, buy, sell" or "buy, sell, cooldown, cooldown"
        buy[1] = 0-prices[0];
        sell[0] = 0;
        for(int i=2;i<=l;i++) {
        	buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i-1]);
        	sell[i] = Math.max(buy[i-1]+prices[i-1], sell[i-1]);
        }
        return sell[l];
	}
}
