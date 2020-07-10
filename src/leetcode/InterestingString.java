package leetcode;

public class InterestingString {

	public InterestingString() {
		// TODO Auto-generated constructor stub
	}

	public boolean dfs(String s, int index) {
		if(index == s.length()) {
			return true;
		}
		int i = index;
		while(i<s.length() && Character.isDigit(s.charAt(i))) {
			int offset = findCount(s, index, i);
			if(dfs(s, i+1+offset)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public int findCount(String s, int from, int to) {
		int res = 0;
		for(int i=from;i<=to;i++) {
			res = res*10+s.charAt(i)-'0';
		}
		return res;
	}
	
	public boolean isInteresting(String s) {
		return dfs(s, 0);
	}
	
	public static void main(String[] args) {
		InterestingString is = new InterestingString();
		System.out.println(is.isInteresting("31ba2a"));
	}
}
