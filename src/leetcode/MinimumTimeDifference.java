package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.util.Pair;

public class MinimumTimeDifference {

	public MinimumTimeDifference() {
		// TODO Auto-generated constructor stub
	}
	public int findMinDifference(List<String> timePoints) {
        List<Pair<Integer, Integer>> time = new ArrayList();
        for(String t: timePoints) {
        	String[] tmp = t.split(":");
        	int hour = Integer.parseInt(tmp[0].substring(0));
        	int minute = Integer.parseInt(tmp[1].substring(0, 2));
        	if(hour == 0) {
        		hour = 24;
        	}
        	time.add(new Pair(hour, minute));
        }
        
        //hashmap sort
        //List<Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(time.entrySet());
        
        Collections.sort(time, new Comparator<Pair<Integer, Integer>>(){
        	public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        		if(o1.getKey()!=o2.getKey()) {
        			return (o1.getKey()).compareTo(o2.getKey());
        		}else {
        			return o1.getValue().compareTo(o2.getValue());
        		}
        	}
        });
        //add additional item, which represents the earliest time plus 24 hours, in order to find the smallest diff
        //from two different directions
        time.add(new Pair(time.get(0).getKey()+24, time.get(0).getValue()));
        int min = Integer.MAX_VALUE;
        int l = timePoints.size();
        int hour = 0;
        int minute = 0;
        for(int i=1;i<=l;i++) {
        	Pair p1 = time.get(i-1);
        	Pair p2 = time.get(i);
        	int diff = Math.abs(60*((int)p2.getKey()-(int)p1.getKey()) + (int)p2.getValue()-(int)p1.getValue());
        	min = Math.min(min, diff);
        }
        return min;
    }
}
