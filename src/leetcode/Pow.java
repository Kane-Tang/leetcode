package leetcode;

public class Pow {
//	public double myPow(double x, int n) {
//		if (n == 0) {
//			return 1;
//		} else if (n > 0) {
//			double ans = 1.0;
//			for (int i = 0; i < n; i++) {
//				ans = ans * x;
//			}
//			return ans;
//		} else if (n < 0) {
//			double ans = 1.0;
//			x = 1 / x;
//			if (n == Integer.MIN_VALUE) {
//				if (x == 1.0 || x == -1.0) {
//					return 1.0;
//				} else {
//					return 0.0;
//				}
//			}
//			n = -n;
//			for (int i = 0; i < n; i++) {
//				ans = ans * x;
//			}
//			return ans;
//		}
//		return 0.0;
//	}

	private double fastPow(double x, long n) {
		if (n == 0) {
			return 1.0;
		}
		double half = fastPow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}

	public double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}

		return fastPow(x, N);
	}
}
