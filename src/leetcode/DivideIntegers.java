package leetcode;

public class DivideIntegers {
	public int divide(int dividend, int divisor) {
		if(dividend == -2147483648 && divisor==1) {
			return -2147483648;
		}else if(dividend == -2147483648 && divisor == -1) {
			return 2147483647;
		}else if(dividend == 2147483647 && divisor==1) {
			return 2147483647;
		}else if(dividend == 2147483647 && divisor == -1) {
			return -2147483648;
		}
		
		int ans = dividend/divisor;
		return ans;
	}
}
