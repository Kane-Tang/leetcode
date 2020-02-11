package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {
	public int compress(char[] chars) {
		int l = chars.length;
		//modify the array
		char c = chars[0];
		int count = 0;
		int pointer = 0;
		for(int i=0;i<l;i++) {
			if(chars[i] == c) {
				count++;
			}else {
				System.out.println(c);
				chars[pointer++] = c;
				c = chars[i];
				
				if(count > 1) {
					while(count>=10) {
						int tmp = count/10;
						chars[pointer++] = Character.forDigit(tmp, 10);
						count = count%10;
					}
					chars[pointer++] = Character.forDigit(count, 10);
				}
				if(i < l-1)
					count = 1;
			}
		}
		chars[pointer++] = c;
		if(count > 1) {
			while(count>=10) {
				int tmp = count/10;
				chars[pointer++] = Character.forDigit(tmp, 10);
				count = count%10;
			}
			chars[pointer++] = Character.forDigit(count, 10);
		}
		return pointer;
	}
}
