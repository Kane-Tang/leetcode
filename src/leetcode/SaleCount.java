package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SaleCount {

	public SaleCount() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, Integer> count = new HashMap();
		for(int i=0;i<=n;i++) {
			String data = in.nextLine();
			count.put(data, count.getOrDefault(data, 0)+1);
			//System.out.println(i);
		}
		Iterator<Map.Entry<String, Integer>> iterator = count.entrySet().iterator();
		int ans = 0;
		String s = "";
		while(iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			if(entry.getValue()>=ans) {
				ans = entry.getValue();
				s = entry.getKey();
			}
		}
		System.out.println(s+" "+ans);
	}
}
