package leetcode;

public class UTF8Validation {
	public boolean validUtf8(int[] data) {
		int l = data.length;
		String[] code = new String[l];
		for(int i=0;i<l;i++) {
			//tranfer to binary
			int tmp = data[i];
			StringBuilder s = new StringBuilder();
			while(tmp>1) {
				int check = tmp%2;
				tmp = tmp/2;
				s.append(check);
			}
			s.append(tmp);
			int count = s.length();
			while(count<8) {
				s.append('0');
				count++;
			}
			String output = "";
			for(int j=s.toString().length()-1;j>=0;j--) {
				output = output+s.toString().charAt(j);
			}
			code[i] = output;
		}
		
		int type = 0;//counts how many 1's in the first binary string
		//check if it's valid
		for(int i=0;i<l;i++) {
			String s;
			if(code[i].length()>8) {
				s = code[i].substring(code[i].length()-8);
			}else {
				s = code[i];
			}
			if(type == 0) {
				//deal with it from the beginning
				for(int j=0;j<s.length();j++) {
					if(s.charAt(j)=='0') {
						break;
					}
					type++;
				}
				if(type==0) {
					continue;
				}//1 byte
				
				if(type>4 || type==1) {
					return false;
				}
				
			}else {
				if(!(s.charAt(0)=='1' && s.charAt(1)=='0')) {
					return false;
				}
			}
			
			type -= 1;
		}
		return type == 0;
		
		
//		int numberOfBytesToProcess = 0;
//
//        // Masks to check two most significant bits in a byte.
//        int mask1 = 1 << 7;
//        int mask2 = 1 << 6;
//
//        // For each integer in the data array.
//        for(int i = 0; i < data.length; i++) {
//            // If this is the case then we are to start processing a new UTF-8 character.
//            if (numberOfBytesToProcess == 0) {
//                int mask = 1 << 7;
//                 while ((mask & data[i]) != 0) {
//                    numberOfBytesToProcess += 1;
//                    mask = mask >> 1;
//                 }
//
//                // 1 byte characters
//                if (numberOfBytesToProcess == 0) {
//                    continue;
//                }
//
//                // Invalid scenarios according to the rules of the problem.
//                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
//                    return false;
//                }
//
//            } else {
//
//                // data[i] should have most significant bit set and
//                // second most significant bit unset. So, we use the two masks
//                // to make sure this is the case.
//                if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) {
//                    return false;
//                }
//            }
//
//            // We reduce the number of bytes to process by 1 after each integer.
//            numberOfBytesToProcess -= 1;
//        }
//
//        // This is for the case where we might not have the complete data for
//        // a particular UTF-8 character.
//        return numberOfBytesToProcess == 0;
		
		
		
//		if(l == 1) {
//			String tmp = code[0];
//			if(tmp.charAt(0)=='0') {
//				return true;
//			}else {
//				return false;
//			}
//		}else if(l == 2) {
//			String tmp1 = code[0];
//			String tmp2 = code[1];
//			if(tmp1.charAt(0)=='1' && tmp1.charAt(1)=='1' && tmp1.charAt(2)=='0' && tmp2.charAt(0)=='1' && tmp2.charAt(1)=='0') {
//				return true;
//			}
//			return false;
//		}else if(l == 3) {
//			String tmp1 = code[0];
//			String tmp2 = code[1];
//			String tmp3 = code[2];
//			if(tmp1.charAt(0)=='1' && tmp1.charAt(1)=='1' && tmp1.charAt(2)=='1' && tmp1.charAt(3)=='0') {
//				if(tmp2.charAt(0)=='1' && tmp2.charAt(1)=='0') {
//					if(tmp3.charAt(0)=='1' && tmp3.charAt(1)=='0') {
//						return true;
//					}
//				}
//			}
//			return false;
//		}else {
//			String tmp1 = code[0];
//			String tmp2 = code[1];
//			String tmp3 = code[2];
//			String tmp4 = code[3];
//			if(tmp1.charAt(0)=='1' && tmp1.charAt(1)=='1' && tmp1.charAt(2)=='1' && tmp1.charAt(3)=='1' && tmp1.charAt(4)=='0') {
//				if(tmp2.charAt(0)=='1' && tmp2.charAt(1)=='0') {
//					if(tmp3.charAt(0)=='1' && tmp3.charAt(1)=='0') {
//						if(tmp4.charAt(0)=='1' && tmp4.charAt(1)=='0') {
//							return true;
//						}
//					}
//				}
//			}
//			return false;
//		}
	}
}
