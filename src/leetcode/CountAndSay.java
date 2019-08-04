package leetcode;

public class CountAndSay {
	public String countAndSay(int n) {
		if(n==1) {
			return "1";
		}
		String res=countAndSay(n-1);
		char tmp=res.charAt(0);//the count
		int count = 0;
		StringBuilder string = new StringBuilder();
		for(int i=0;i<res.length();i++){
			if(tmp!=res.charAt(i)) {
				string.append(count);
				string.append(tmp);
				tmp = res.charAt(i);
				count=1;
			}else {
				count++;
			}
		}
		if(count>0) {
			string.append(count+String.valueOf(tmp));
		}else {
			string.append("");
		}
		return string.toString();
	}
	
	public static void main(String[] args) {
		CountAndSay cs = new CountAndSay();
		System.out.println(cs.countAndSay(3));
	}
}
