package leetcode;

public class FibonacciNumber {
	public int fib(int N) {
		//recursion
//		if(N == 0) {
//			return 0;
//		}
//		if(N == 1) {
//			return 1;
//		}
//		return fib(N-1)+fib(N-2);
		if(N == 0) {
			return 0;
		}
		if(N == 1) {
			return 1;
		}
		int[] f = new int[N+1];
		f[0]=0;
		f[1]=1;
		for(int i=2;i<=N;i++) {
			f[i]=f[i-1]+f[i-2];
		}
		return f[N];
	}
}
