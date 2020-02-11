package leetcode;

public class StringAdd {

	public StringAdd() {
		// TODO Auto-generated constructor stub
	}

	public String addStrings(String num1, String num2) {
		int l1 = num1.length();
		int l2 = num2.length();
		int num = 0;
		int i = l1-1;
		int j = l2-1;
		int add = 0;
		StringBuilder s = new StringBuilder();
		while(i>=0 && j>=0) {
			char a = num1.charAt(i);
			char b = num2.charAt(j);
			int tmp = a-'0'+b-'0';
			tmp += add;
			if(tmp>=10) {
				add = tmp/10;
				tmp = tmp-add*10;
			}else {
				add = 0;
			}
			s.append(tmp);
			i--;
			j--;
		}
		while(i>=0) {
			char a = num1.charAt(i);
			int tmp = a - '0'+add;
			if(tmp>=10) {
				add = tmp/10;
				tmp = tmp-add*10;
			}else {
				add = 0;
			}
			s.append(tmp);
			i--;
		}
		while(j>=0) {
			char a = num2.charAt(j);
			int tmp = a - '0'+add;
			if(tmp>=10) {
				add = tmp/10;
				tmp = tmp-add*10;
			}else {
				add = 0;
			}
			s.append(tmp);
			j--;
		}
		if(add>0) {
			s.append(add);
		}
		return s.reverse().toString();
	}
}
