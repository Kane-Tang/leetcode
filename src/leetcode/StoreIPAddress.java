package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StoreIPAddress {

	public StoreIPAddress() {
		// TODO Auto-generated constructor stub
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList();
		findAns(s, ans, 0, "", 0);
		return ans;
	}
	
	public void findAns(String s, List<String> ans, int index, String cur, int count) {
		if(s.length()-index > 3*(4-count)) {
			return;//too long
		}
		if(count == 4 && index == s.length()) {
			ans.add(cur);
			return;
		}
		
		//go dfs
		for(int i=1;i<=3;i++) {
			if(index+i > s.length()) {
				return;
			}
			String part = s.substring(index, index+i);
			if(part.length() > 1 && part.startsWith("0")) {
				continue;
			}else if(i==3 && Integer.valueOf(part) >= 256) {
				continue;
			}else {
				findAns(s, ans, index+i, count==0 ? part : cur+"."+part, count+1);
			}
		}
	}
}
