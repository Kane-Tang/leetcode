package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubDomain {
	public List<String> subdomainVisits(String[] cpdomains) {
		int l = cpdomains.length;
		HashMap<String, Integer> hm = new HashMap();
		for(int i=0;i<l;i++) {
			String[] s= cpdomains[i].split(" ");
			int count = Integer.parseInt(s[0]);
			String[] names = s[1].split("\\.");
			String cur = "";
			for(int j=names.length-1;j>=0;j--) {
				int currentCount = hm.getOrDefault(names[j], 0);
				if(j == names.length-1) {
					cur = names[j]+cur;
				}else {
					cur = names+"."+cur;
				}
				hm.put(cur, currentCount+count);
			}
		}
		
		int size = hm.size();
		List<String> list = new ArrayList();
		for(String domains: hm.keySet()) {
			list.add(hm.get(domains) + " " + domains);
		}
		return list;
	}
}
