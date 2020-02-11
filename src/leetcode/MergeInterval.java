package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
	private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
		int l = intervals.size();
		List<Interval> res = new ArrayList();
		if(l == 0) {
			return res;
		}
		int count = 0;
		res.add(intervals.get(0));
		for(int i=1;i<l;i++) {
			Interval t1 = res.get(count);
			Interval t2 = intervals.get(i);
			if(t1.end>=t2.start) {
				res.remove(count);
				Interval tmp = new Interval(Math.min(t1.start, t2.start),Math.max(t1.end, t2.end));
				res.add(tmp);
			}
			else {
				res.add(t2);
				count++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		MergeInterval mi = new MergeInterval();
		Interval i1 = new Interval(2,6);
		Interval i2 = new Interval(1,3);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15,18);
		List<Interval> list = new ArrayList();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		List<Interval> ans = new ArrayList();
		ans = mi.merge(list);
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i).start);
			System.out.print(" ");
			System.out.print(ans.get(i).end);
			System.out.println();
		}
	}
}
