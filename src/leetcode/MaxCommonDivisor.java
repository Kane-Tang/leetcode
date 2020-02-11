package leetcode;

public class MaxCommonDivisor {

	public MaxCommonDivisor() {
		// TODO Auto-generated constructor stub
	}

	public int maxCommonDivisor(int m, int n) {
		if (m < n) {//make m > n
			int temp = m;
			m = n;
			n = temp;
		}
		if (m % n == 0) {
			return n;
		} else {
			return maxCommonDivisor(n, m % n);
		}
	}

	public int maxCommonDivisor2(int m, int n) {
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		while (m % n != 0) {
			int temp = m % n;
			m = n;
			n = temp;
		}
		return n;
	}
	
	public int minCommonMultiple(int m, int n) {
		return m * n / maxCommonDivisor(m, n);
	}

}
