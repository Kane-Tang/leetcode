package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {

	public UglyNumber() {
		// TODO Auto-generated constructor stub
	}

	public boolean isUgly(int num) {
		List<Integer> list = new ArrayList();
		if(num <= 0) {
			return false;
		}
		findPrimeFactors(list, num);
		for(int i=0;i<list.size();i++) {
			int tmp = list.get(i);
			if(tmp == 2 || tmp == 3 || tmp == 5) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	public void findPrimeFactors(List<Integer> list, int num) {
		int n = (int) Math.sqrt(num);
		for(int i=1;i<=n;i++) {
			if(num%i == 0) {
				if(isPrime(i)) {
					list.add(i);
				}
				if(isPrime(num/i)) {
					list.add(num/i);
				}
			}
		}
	}
	
	public boolean isPrime(int num) {
		int n = (int) Math.sqrt(num);
		if(num == 1) {
			return false;
		}
		if(num == 2 || num == 3) {
			return true;
		}
		for(int i=2;i<=n;i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
}
