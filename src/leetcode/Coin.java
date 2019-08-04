package leetcode;

import java.util.Arrays;

public class Coin {
	public int coinChange(int[] coins, int amount) {
		int l = coins.length;
		quickSort(coins,0,l-1);
		if(amount<1) {
			return 0;
		}
		return findAns(coins, amount, new int[amount]);
	}
	
	public int findAns(int[] coins, int amount, int[] count) {
		//count[i], save the least number of coins in order to get the amount i
		//top down
		//has an optimal substructure property, which is the key piece in solving any Dynamic Programming problems
		if(amount<0) {
			return -1;
		}
		if(amount==0) {
			return 0;
		}
		if(count[amount-1]!=0) {
			//already find this type of coins choice, don't need to calculate again
			return count[amount-1];
		}
		int min = Integer.MAX_VALUE;
		for(int coin: coins) {
			int res = findAns(coins, amount - coin, count);
			//reasonable result, ignore the ones < 0, which means can't be the change 
            if (res >= 0 && res < min)
                min = 1 + res;//choose the current coin
		}
		count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
	}
	
	public int findAns(int[] coins, int amount) {
		//bottom up
		int max = amount + 1;             
        int[] dp = new int[amount + 1];  
        Arrays.fill(dp, max);  
        dp[0] = 0;   
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
	}
	
	public void quickSort(int[] nums, int low, int high) {
		if(low<high) {
			int par = partitions(nums, low, high);
			quickSort(nums, low, par - 1);
			quickSort(nums, par + 1, high);
		}
		
	}
	
	public int partitions(int[] nums, int low, int high) {
		int par = nums[high];
		int i = low-1;
		for(int j=low;j<high;j++) {
			if(nums[j]<=par) {
				i++;
				int temp = nums[j];
				nums[j]=nums[i];
				nums[i]=temp;
			}
		}
		int temp = nums[i+1];
		nums[i+1]=nums[high];
		nums[high]=temp;
		return i+1;
	}
}
