package leetcode;

public class MinimumDominoRotation {

	public MinimumDominoRotation() {
		// TODO Auto-generated constructor stub
	}

	public int minDominoRotations(int[] A, int[] B) {
		int l = A.length;
		int res = rotate(A[0], A, B);
		//the final ans must be either A[0] or B[0], otherwise return -1
		if(res != -1 || A[0]==B[0]) {
			return res;
		}else {
			return rotate(B[0], B, A);
		}
	}
	
	public int rotate(int sym, int[] A, int[] B) {
		int pa = 0;
		int pb = 0;
		for(int i=0;i<A.length;i++) {
			if(A[i] != sym && B[i] != sym) {
				return -1;
			}
			if(A[i] != sym) {
				pa++;
			}else if(B[i] != sym) {
				pb++;
			}
		}
		return Math.min(pa, pb);
	}
}
