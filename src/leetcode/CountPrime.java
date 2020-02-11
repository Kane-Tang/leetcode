package leetcode;

public class CountPrime {

	public CountPrime() {
		// TODO Auto-generated constructor stub
	}

	public int countPrimes(int n) {
		int count = 0;
		if(n==2) {
			return 0;
		}
		if(n==3) {
			return 1;
		}
		for(int i=2;i<n;i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		return count;
	}
	
	public boolean isPrime(int n) {
		int l = (int) Math.sqrt(n);
		for(int i=2;i<=l;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
