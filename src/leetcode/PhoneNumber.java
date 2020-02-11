package leetcode;

import java.util.Scanner;

public class PhoneNumber {

	public PhoneNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			int n = in.nextInt();
			String s = in.next();
			if(n<11) {
				System.out.println("NO");
				continue;
			}
			boolean flag = false;
			for(int j=0;j<s.length();j++) {
				//after 8, still at least 10 character
				if(s.charAt(j) == '8') {
					if(s.length()-j-1>=10) {
						flag = true;
						break;
					}
				}
			}
			if(flag == false) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
}
