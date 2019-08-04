package leetcode;

public class MultiplyString {
	public String multiply(String num1, String num2) {
		int l1 = num1.length();
		int l2 = num2.length();
		int num=0;
		int add=0;
		int[] n1 = new int[l1+l2];
		StringBuilder ans = new StringBuilder();
		for(int j=l2-1;j>=0;j--) {
			for(int i=l1-1;i>=0;i--) {
				num = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+n1[i+j+1];
				add=num/10;
				num = num-add*10;
				n1[i+j+1] = num;
				n1[i+j] += add;
//				if(i==0) {
//					n1[i+j] += add;
//				}
			}
			add = 0;
			for(int q=0;q<l1+l2;q++) {
				System.out.print(n1[q]);
			}
			System.out.println();
		}
		for(int tmp: n1) {
			if(!(ans.length() == 0 && tmp == 0)) {
				ans.append(tmp);
			}
			
		}
		if(ans.length()==0) {
			return "0";
		}
		return ans.toString();
	}
	
	public static void main(String[] args) {
		MultiplyString ms = new MultiplyString();
		System.out.println(ms.multiply("123", "456"));
	}
}
