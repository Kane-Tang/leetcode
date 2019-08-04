package leetcode;

public class AddBinary {
	public String addBinary(String a, String b) {
		int l1 = a.length();
		int l2 = b.length();
		int i=l1-1;
		int j=l2-1;
		int add = 0;
		StringBuilder ans = new StringBuilder();
		while(i>=0 || j>=0) {
			int n1 = 0;
			int n2 = 0;
			if(i < 0) {
				n1 = 0;
			}
			else {
				n1 = Character.getNumericValue(a.charAt(i));
			}
			
			if(j < 0) {
				n2 = 0;
			}
			else {
				n2 = Character.getNumericValue(b.charAt(j));
			}

			int n = n1 + n2 + add;
			if(n == 0) {
				ans.append('0');
				add = 0;
			}
			if(n == 1){
				ans.append('1');
				add = 0;
			}
			if(n == 2) {
				ans.append('0');
				add = 1;
			}
			if(n == 3) {
				ans.append('1');
				add = 1;
			}
			i--;
			j--;
		}
		if(add!=0) {
			ans.append(add);
		}
		StringBuilder res = new StringBuilder();
		int l = ans.length();
		for(int q = l-1;q>=0;q--) {
			res.append(ans.charAt(q));
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		String a = "11";
		String b = "1";
		System.out.println(ab.addBinary(a, b));
	}
}
