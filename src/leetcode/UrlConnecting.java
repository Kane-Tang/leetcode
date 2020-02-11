package leetcode;

import java.util.Scanner;

public class UrlConnecting {

	public UrlConnecting() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String u1 = in.next();
		String u2 = in.next();
		StringBuilder ans = new StringBuilder(u1);
		if(u1.length()==0 && u2.length()==0) {
			System.out.println("/");
			return;
		}
		if(u1.length()==0) {
			System.out.println(u2);
			return;
		}
		if(u2.length()==0) {
			System.out.println(u1);
			return;
		}
		if(u1.charAt(u1.length()-1)=='/') {
			ans.deleteCharAt(u1.length()-1);
		}
		if(u2.charAt(0)=='/') {
			ans.append(u2);
		}else {
			ans.append("/").append(u2);
		}
		System.out.println(ans.toString());
	}
}
