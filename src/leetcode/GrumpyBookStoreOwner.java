package leetcode;

public class GrumpyBookStoreOwner {

	public GrumpyBookStoreOwner() {
		// TODO Auto-generated constructor stub
	}

	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int l = customers.length;
		// slide window
		//greedy
		int res = 0;
		int satisfied = 0;
		int unsatisfied = 0;
		for(int i=0;i<l;i++) {
			if(grumpy[i] == 0) {
				satisfied += customers[i];
			}else {
				unsatisfied += customers[i];
			}
			
			//greedy
			if(i>=X) {
				if(grumpy[i-X] == 1) {
					unsatisfied -= customers[i-X];
				}
			}
			res = Math.max(res, unsatisfied);
		}
		return satisfied + res;
	}
}