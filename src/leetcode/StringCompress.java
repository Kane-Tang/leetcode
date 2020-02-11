package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StringCompress {
	//input: HG[3|B[2|CA]]F
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int l = s.length();
		Stack<Character> queue = new Stack();
		
		for(int i=0;i<l;i++) {
			if(s.charAt(i)!=']') {
				queue.push(s.charAt(i));
			}else {
				char c = queue.pop();

				StringBuilder str = new StringBuilder();
				while(c!='|') {
					System.out.println(c);
					//find the substring
					str.append(c);
					c = queue.pop();
				}
				String sub = str.toString();
				c = queue.pop();
				
				int num = 0;
				while(c!='[') {
					num = num*10+c-'0';
					c=queue.pop();
				}
				for(int j=0;j<num;j++) {
					for(int q = sub.length()-1;q>=0;q--) {
						queue.push(sub.charAt(q));
					}
				}
			}
		}
		
		StringBuilder ans = new StringBuilder();
		while(!queue.isEmpty()) {
			ans.append(queue.pop());
		}
		System.out.println(ans.reverse().toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String s = in.nextLine();
//		int l = s.length();
//		Stack<Integer> stack = new Stack();
//		int num = 0;
//		LinkedList<Integer> beginIndex = new LinkedList();
//		LinkedList<Integer> endIndex = new LinkedList();
//		String ans = findAns(s, stack, 0, beginIndex, endIndex);
//		System.out.println(ans);
//	}
	
	public static String findAns(String s, Stack<Integer> stack, int index, LinkedList<Integer> beginIndex, LinkedList<Integer> endIndex) {
		//System.out.println(s);
		int l = s.length();
		int num = 0;
		StringBuilder tmp = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		int beg = 0;
		int end = 0;
		boolean flag = true;
		for(int i=0;i<l;i++) {
			char c = s.charAt(i);
			if(c>='0' && c<='9') {
				if(flag==true)
					num = num*10+c-'0';
			}else if(c=='|') {
				continue;
			}else if(c>='A' && c<='Z') {
				if(flag==true)
					tmp.append(c);
			}else if(c=='[') {
				beg = i;
				//System.out.println(beg+"**"+index);
				if(beginIndex.contains(beg+index+1)) {
					int ind = beginIndex.indexOf(beg+index+1);
					i = endIndex.get(ind);
					continue;
				}
				flag = false;
				stack.push(beg);
				beginIndex.add(beg+index);
				beg = 0;
			}else if(c==']') {
				if(stack.isEmpty()) {
					continue;
				}
				end = i;
//				if(endIndex.contains(end)) {
//					continue;
//				}
				endIndex.add(end);
				//System.out.println("findend"+end);
				int b = stack.pop();
				String re = s.substring(b+1, end);
				tmp.append(findAns(re,stack, b, beginIndex, endIndex));
				//flag = true;
			}
		}
		System.out.println(num+"*************"+tmp);
		//System.out.println(num+"!!!!!!!!!!");
		if(num==0) {
			ans.append(tmp.toString());
			return ans.toString();
		}
		for(int i=0;i<num;i++) {
			ans.append(tmp.toString());
		}
		//System.out.println(ans+"!!!!!!!!!!!");
		return ans.toString();
	}
}
