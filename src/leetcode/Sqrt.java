package leetcode;

public class Sqrt {
	public int mySqrt(int x) {
		if(x==0) {
			return 0;
		}
		int left = 1;
		int right = Integer.MAX_VALUE;
		while(true) {
			int mid = left + (right-left)/2;//beyond border
			if(mid > x/mid) {
				right = mid - 1;
			}else {
				if((mid+1) > x/(mid+1)) {
					return mid;
				}
				left = mid + 1;
			}
		}
	}
}
