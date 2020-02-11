package leetcode;

public class RemoveAdjacentDuplicate {

	public RemoveAdjacentDuplicate() {
		// TODO Auto-generated constructor stub
	}
	
	public String removeDuplicates(String S) {
		StringBuilder sb = new StringBuilder();
	    int sbLength = 0;
	    for(char character : S.toCharArray()) {
	      if (sbLength != 0 && character == sb.charAt(sbLength - 1))
	        sb.deleteCharAt(sbLength-- - 1);
	      else {
	        sb.append(character);
	        sbLength++;
	      }
	    }
	    return sb.toString();
    }
	
	public String deleteDup(String S) {
        int l = S.length();
        StringBuilder newString = new StringBuilder();
        int count = 0;
        for(int i=0;i<l;i++) {
        	if(newString.length() != 0 && newString.charAt(newString.length()-1) == S.charAt(i)) {
        		newString.deleteCharAt(count-- - 1);
        		continue;
        	}else {
        		newString.append(S.charAt(i));
        		count++;
        	}
        }
        return newString.toString();
	}
}
