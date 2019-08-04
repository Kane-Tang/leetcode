package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Email {
	public int numUniqueEmails(String[] emails) {
        int l = emails.length;
        int ans = 0;
        Set<String> set = new HashSet();
        for(int i=0;i<l;i++) {
        	int index = emails[i].indexOf("@");
        	String name = emails[i].substring(0, index);
        	String domain = emails[i].substring(index);
        	if(name.contains("+")) {
        		name = name.substring(0, name.indexOf("+"));
        	}
        	name = name.replaceAll("/.", "");
        	System.out.println(name);
        	set.add(name+domain);
        }
        ans = set.size();
        return ans;
//		int l = emails.length;
//		int ans = l;
//		long[] hashes = new long[l];
//		for(int i=0;i<l;i++) {
//			String tmp = emails[i];
//			boolean ignore = false;
//			boolean domain = false;
//			long hash = 0;
//			for(int j=0;j<tmp.length();j++) {
//				char c = tmp.charAt(j);
//				if(domain) {
//					hash = (hash<<5)+hash+c;
//					continue;
//				}
//				if(c=='@') {
//					domain = true;
//					continue;
//				}
//				if(ignore) {
//					continue;
//				}
//				if(c=='.') {
//					continue;
//				}
//				if(c=='+') {
//					ignore = true;
//					continue;
//				}
//				hash = (hash<<5)+hash+c;
//				continue;
//			}
//			hash = hash & 0xFF;
//			System.out.println(hash);
//			hashes[i] = hash;
//			for(int q = i-1;q>=0;q--) {
//				if(hashes[q] == hash) {//same
//					ans--;
//					break;
//				}
//			}
//		}
//		return ans;
    }
	
	public static void main(String[] args) {
		String[] emails = new String[] {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
				//{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		Email e = new Email();
		System.out.println(e.numUniqueEmails(emails));
	}
}
