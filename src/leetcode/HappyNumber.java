package leetcode;

public class HappyNumber {
	public boolean isHappy(int n) {
        if(n==1 || n==7) return true;
        else if(n<10) return false;
        int d=0;
        while(n>0){
            d+=(n%10)*(n%10);
            n/=10;
        }
        return isHappy(d);
	}
		/**
		We need HashMap/HashSet to store if a number is visited. If we take a closer look then the sum of  number will never exceed (9^2*9).
		Hence create a boolean array of this size to maintain the visited nodes.Take care of the first number which is passed in arguments. 
		Note :- HashMap solution is best one but it takes around 6 ms to run no matter how much optimization you do. Hence I tried this with an array because array size is limited. 
		*/
//        boolean[] map = new boolean[729];
//	    boolean result = false;
//        // default check for 1
//	    if(n == 1 ) return true; 
//        // take care of the first number which is passed as an argument. It can be a larger that array size.
//	    n = getSum(n); 
//        // loop till not found or not revisited
// 	    while(!result && !map[n]){     	       
//            map[n] = true;
//	        n = getSum(n); 
//	        result = n == 1;
//	    }
// 	    return result;
//    }
//	
//	private int getSum(int n){
//		int sum = 0;
//		while (n > 0) {
//			int digit = n % 10;
//			sum += digit * digit;
//			n = n / 10;
//		}
//		return sum;
//	}
}
