package leetcode;

public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		int ans = 0;
		int l1 = J.length();
		int l2 = S.length();
		for(int i=0;i<l2;i++) {
			char s = S.charAt(i);
			for(int j=0;j<l1;j++) {
				if(s == J.charAt(j)) {
					ans++;
					break;
				}
			}
		}
		return ans;
	}
}
