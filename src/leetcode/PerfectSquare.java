package leetcode;

public class PerfectSquare {
	/**
	 * s[i] denotes the least number of square numbers that add up to n
	 * initial s[i] as maximum integer
	 * for i from 1 to n, 
	 *      if i is perfect square, s[i]=1, 
	 *      otherwise get the square root of the maximum perfect square smaller than i
	 * for j from 1 to square root, 
	 *      if(s[i-j*j]+1<s[i]) update s[i] as s[i-j*j]+1
	 * 
	 * */
	public int numSquares(int n) {
		int[] s = new int[n+1];
	    for(int i=0;i<n+1;i++) {
	    	s[i] = Integer.MAX_VALUE;
	    }
	    //note to me: no need to store a list of perfect squares, knowing the square root of the largest perfect square is sufficient
	    //List<Integer> squares = new ArrayList<Integer>();
	    for(int i = 1;i<n+1;i++){
	        int sqrt = (int) Math.sqrt(i);
	        if(i == sqrt*sqrt){
	        	s[i] = 1;//find one res: sqrt, which means i = sqrt*sqrt, length = 1
	        	continue;
	        }
	        //dp method
	        //find the smallest one
	        //then i = sqrt*sqrt + x*x + y*y + ..., where other items won't be larger than sqrt
	        for(int j = 1;j<=sqrt;j++){
	            if(s[i-j*j]+1<s[i]) {
	            	s[i] = s[i-j*j]+1;
	            }
	        }
	    }
	    return s[n];
	}
	
	public static void main(String[] args) {
		PerfectSquare ps = new PerfectSquare();
		//System.out.println((int)Math.sqrt(5));
		System.out.println(ps.numSquares(12));
	}
}
