package leetcode;

public class ReverseWordsInString {

	public ReverseWordsInString() {
		// TODO Auto-generated constructor stub
	}

	public String reverseWords(String s) {
		String[] data = s.split(" ");/*when use split(" "), even there are multiple spaces, the substring
		divided by " " will still be ""*/
		/*eg: "  hello world!       ", then s.split(" "), then the output will be "",hello,world!,""*/
		StringBuilder res = new StringBuilder();
		for(int i=data.length-1;i>=0;i--) {
			if(data[i].equals("")) {
				continue;
			}
			res.append(data[i]);
			res.append(" ");
		}
		if(res.toString().equals("")) {
			return "";
		}
		res.deleteCharAt(res.length()-1);

		return res.toString();
	}
}
