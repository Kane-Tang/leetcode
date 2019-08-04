package leetcode;

public class DecodeString {
//	public String decodeString(String s) {
//		int l = s.length();
//		for(int i=0;i<l;i++) {
//			char c = s.charAt(i);
//			int time = 0;
//			if(c>=48 && c<=57) {//number
//				time = c-48;
//				continue;
//			}
//			
//			if(c>=97 && c<=122) {//letter
//				
//			}
//		}
//	}
	
	public String decodeString(String s) {
        if (!s.contains("[") || !s.contains("]")) //no multiplication
        	return s;
        int i = 0;//index
        StringBuilder retString = new StringBuilder();//output
        char[] chars = s.toCharArray();
        while (i < chars.length) {
            StringBuilder numBuilder = new StringBuilder();
            while (!Character.isDigit(chars[i])) {// not number
                retString.append(chars[i++]);
                if(i >= chars.length) //out of range
                	return retString.toString();
            }
            while (chars[i] != '[')
                numBuilder.append(chars[i++]);
            i++;
            int times = Integer.parseInt(numBuilder.toString());
            int openCounter = 1;//check the level of '['
            StringBuilder innerSubStringRep = new StringBuilder();

            while (openCounter != 0) {
                char curChar = chars[i++];
                if (curChar == '[') 
                	openCounter++;
                else if (curChar == ']') 
                	openCounter--;
                if (openCounter != 0)
                    innerSubStringRep.append(curChar);
            }
            String innerSubstring = decodeString(innerSubStringRep.toString());
            for (int j = 0; j < times; j++)
                retString.append(innerSubstring);
        }
        return retString.toString();
    }
	
	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("3[a]2[bc]"));
	}
}
