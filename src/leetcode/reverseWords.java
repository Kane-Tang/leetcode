package leetcode;

public class reverseWords {

	public reverseWords() {
		// TODO Auto-generated constructor stub
	}

	public String reverseWords(String s) {
		String[] data = s.split(" ");
		int l = data.length;
		StringBuilder res = new StringBuilder();
		int count = 0;
		for(String tmp: data) {
			count++;
			StringBuilder d = new StringBuilder();
			d.append(tmp);
			res.append(d.reverse());
			if(count!=l)
				res.append(" ");
		}
		return res.toString();
	}
}
