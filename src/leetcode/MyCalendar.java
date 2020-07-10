package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyCalendar {

	private List<int[]> interval;
	private List<int[]> overlap;
	public MyCalendar() {
		// TODO Auto-generated constructor stub
		this.interval = new ArrayList();
		this.overlap = new ArrayList();
	}

	public boolean book(int start, int end) {
		for(int[] it: this.interval) {
			int s = Math.max(it[0], start);
			int e = Math.min(it[1], end);
			if(s < e) {
				//exist overlap
				for(int[] op: this.overlap) {
					if(Math.max(op[0], s) < Math.min(op[1], e)) {
						//another overlap
						overlap.clear();//should clear each time because the current interval may not be added
						return false;
					}
				}
				this.overlap.add(new int[] {s, e});
			}
		}
		interval.add(new int[] {start, end});
		return true;
	}
	
	public static void main(String[] args) {
		MyCalendar mc = new MyCalendar();
		System.out.println(mc.book(10, 20));
		System.out.println(mc.book(50, 60));
		System.out.println(mc.book(10, 40));
		System.out.println(mc.book(5, 15));
		System.out.println(mc.book(5, 15));
		System.out.println(mc.book(5, 10));
		System.out.println(mc.book(25, 55));
	}
}
