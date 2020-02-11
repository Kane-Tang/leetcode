package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList();
		for(int i=1;i<=n;i++) {
			StringBuilder s = new StringBuilder();
			if(i%3==0 || i%5==0) {
				if(i%3 == 0) {
				s.append("Fizz");
				}
				if(i%5 == 0) {
					s.append("Buzz");
				}
			}
			else {
				s.append(i);
			}
			list.add(s.toString());
		}
		return list;
	}
}
