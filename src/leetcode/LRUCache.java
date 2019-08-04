package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCache {
	private int num;
	private int capacity;
	LinkedHashMap<Integer, Integer> list = new LinkedHashMap();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if(list.containsKey(key)) {
			int ans = list.get(key);
			list.remove(key);
			list.put(key, ans);
			return ans;
		}
		else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if(this.list.containsKey(key)) {
			list.remove(key);
			list.put(key, value);
			return;
		}
		if(this.num<this.capacity) {
			this.list.put(key, value);
			this.num++;
		}else {
			Iterator<Entry<Integer, Integer>> iterator = list.entrySet().iterator();
			Entry<Integer, Integer> entry = iterator.next();
			list.remove(entry.getKey());
			this.list.put(key, value);
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));        // returns 3
		System.out.println(cache.get(4));        // returns 4
	}
}
