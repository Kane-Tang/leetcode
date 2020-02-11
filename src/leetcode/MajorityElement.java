package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int l = nums.length;
		HashMap<Integer, Integer> count = new HashMap();
		for(int i=0;i<l;i++) {
			count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
		}
		
		Iterator<Map.Entry<Integer, Integer>> iterator = count.entrySet().iterator();
		int ans = 0;
		int num = 0;
		while(iterator.hasNext()) {
			Entry<Integer, Integer> entry = iterator.next();
			if(entry.getValue()>num) {
				ans = entry.getKey();
				num = entry.getValue();
			}
		}
		return ans;
	}
}
