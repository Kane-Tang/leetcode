package leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int l = digits.length;
		int[] ans = new int[l];
		int add = 1;
		for(int i=l-1;i>=0;i--) {
			int res = digits[i]+add;
			if(res==10) {
				add = 1;
				ans[i] = 0;
			}else {
				ans[i] = res;
				add = 0;
			}
		}
		if(add == 1) {
			int[] add_ans = new int[l+1];
			for(int i=l;i>=1;i--) {
				add_ans[i] = ans[i-1];
			}
			add_ans[0] = add;
			return add_ans;
		}
		return ans;
	}
}
