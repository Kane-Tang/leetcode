package leetcode;

public class OneEditDistance {

	public OneEditDistance() {
		// TODO Auto-generated constructor stub
	}

	public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length();
		int l2 = t.length();
		if (Math.abs(l1 - l2) > 1) {
			return false;
		}
        if(l1==0 && l2==0){
            return false;
        }
        if(l1==0 && l2!=0){
            return true;
        }
        if(l1!=0 && l2==0){
            return true;
        }
		if (l1 == l2) {
			// replace
			int i = 0;
			int j = 0;
			int count = 0;
			while (i < l1 && j < l2) {
				if (s.charAt(i) != t.charAt(j)) {
					count++;
				}
				i++;
				j++;
			}
			if (count == 1) {
				return true;
			} else {
				return false;
			}
		}

		if (l1 < l2) {
			// insert
			int i = 0;
			int j = 0;
			int count = 0;
			while (i < l1 && j < l2) {
				if (s.charAt(i) != t.charAt(j)) {
					count++;
					j++;
				} else {
					i++;
					j++;
				}
			}
            count += l2-j;
			if (count == 1) {
				return true;
			} else {
				return false;
			}
		}

		if (l1 > l2) {
			// delete
			int i = 0;
			int j = 0;
			int count = 0;
			while (i < l1 && j < l2) {
				if (s.charAt(i) != t.charAt(j)) {
					count++;
					i++;
				} else {
					i++;
					j++;
				}
			}
            count += l1-i;
			if (count == 1) {
				return true;
			} else {
				return false;
			}
		}
		return false;
    }
}
