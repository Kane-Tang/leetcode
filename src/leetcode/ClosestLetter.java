package leetcode;

public class ClosestLetter {

	public ClosestLetter() {
		// TODO Auto-generated constructor stub
	}

	public int findDistance(String s, char a, char b) {
		int l = s.length();
		int res = Integer.MAX_VALUE;
		//find index1
		int index1 = 0;
		int index2 = 0;
		
		while(index1<l && index2<l) {
			if(s.charAt(index1)==a && s.charAt(index2)==b) {
				if(Math.abs(index2-index1) < res) {
					res = Math.abs(index2-index1);
				}
			}
			//move index2
			index2++;
			if(index2 == l) {
				index1++;
				index2 = 0;
				continue;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ClosestLetter cl = new ClosestLetter();
		System.out.println(cl.findDistance("geogle", 'g', 'e'));
	}
}
