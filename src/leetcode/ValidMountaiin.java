package leetcode;

public class ValidMountaiin {

	public ValidMountaiin() {
		// TODO Auto-generated constructor stub
	}

	public boolean validMountainArray(int[] A) {
		int l = A.length;
		if(l < 3) {
			return false;
		}
		int mount = 0;
		int index = 0;
		for(int i=1;i<l;i++) {
			if(A[i] > A[i-1]) {//incresing
				continue;
			}else {
				mount = A[i-1];
				index = i-1;
				break;
			}
		}
		for(int i=index+1;i<l;i++) {
			if(A[i] < A[i-1]) {
				continue;
			}else {
				return false;
			}
		}
		if(index == 0) {
			return false;
		}
		return true;
	}
}
