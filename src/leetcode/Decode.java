package leetcode;

public class Decode {
	public int numDecodings(String s) {
		int l = s.length();
		if(l==1&&s.charAt(0)=='0') {
			return 0;
		}
		if(s.charAt(0)=='0') {
			return 0;
		}
		if(l==0) {
			return 0;
		}
		if(l==1&&s.charAt(0)!='0') {
			return 1;
		}
		//dfs search
		int[] ans = new int[l+1];
		ans[l] = 1;
		if(s.charAt(l-1)=='0') {
			ans[l-1] = 0;
		}else {
			ans[l-1] = 1;
		}
		
		for(int i=l-2;i>=0;i--) {
			if(s.charAt(i) == '0') {
				continue;
			}
//			int tmp = 0;
//			if(s.charAt(i)=='1') {
//				tmp++;
//			}
//			if(s.charAt(i)=='2' && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '6') {
//				tmp++;
//			}
//			ans[i] = ans[i+1]+tmp;
//			System.out.println(ans[i]);
			ans[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? ans[i+1]+ans[i+2] : ans[i+1];
		}
		return ans[0];
	}
	
	public static void main(String[] args) {
		Decode d = new Decode();
		String s = "100";
		System.out.println(d.numDecodings(s));
	}
}
