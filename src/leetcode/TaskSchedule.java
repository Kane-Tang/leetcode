package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskSchedule {
	public int leastInterval(char[] tasks, int n) {
		int l = tasks.length;
		HashMap<Character,Integer> hm = new HashMap();
		for(int i=0;i<l;i++) {
			if(hm.containsKey(tasks[i])) {
				int count = hm.get(tasks[i]);
				count++;
				hm.put(tasks[i], count);
			}else {
				hm.put(tasks[i], 1);
			}
		}
		//sort
		List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>(){
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		//int time = 0;
		
		
//		int[] map = new int[26];
//        for (char c: tasks)
//            map[c - 'A']++;
//        Arrays.sort(map);
//        int time = 0;
//        while (map[25] > 0) {
//            int i = 0;
//            while (i <= n) {
//                System.out.println(map[25]);
//                if (map[25] == 0){
//                    break;
//                }
//                    
//                if (i < 26 && map[25 - i] > 0)
//                    map[25 - i]--;//other task
//                time++;//idle 
//                i++;
//            }
//            Arrays.sort(map);
//        }
//        return time;
        
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
	}
}
