package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Equations {
	public boolean equationsPossible(String[] equations) {
		int l = equations.length;
		HashMap<Character, Set<Character>> hm = new HashMap();
		for(int i=0;i<l;i++) {
			String data = equations[i];
			if(data.charAt(1)=='=') {
				Set<Character> s = hm.getOrDefault(data.charAt(0), new HashSet());
				s.add(data.charAt(0));
				s.add(data.charAt(3));
				hm.put(data.charAt(0), s);
				
				Set<Character> copy = hm.get(data.charAt(3));
				if(copy!=null && copy!=s) {
					for(Character c: copy) {
						s.add(c);
						hm.put(c, s);
					}
					
				}else {
					hm.put(data.charAt(3), s);
				}
			}
		}

		for(int i=0;i<l;i++) {
			String data = equations[i];
			if(data.charAt(1) == '!') {
				if(data.charAt(0) == data.charAt(3)) {
					return false;
				}
				if(hm.containsKey(data.charAt(0)) && hm.get(data.charAt(0)).contains(data.charAt(3))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] data = s.split(" ");
		Equations e = new Equations();
		System.out.println(e.equationsPossible(data));
	}
}
