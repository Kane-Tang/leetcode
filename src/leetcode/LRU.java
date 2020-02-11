package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRU {
	HashMap<Integer, Integer> memory = new HashMap();
	int count = 0;
	int size = 0;
	Queue<Integer> q = new LinkedList();

	public LRU(int capacity) {
		// TODO Auto-generated constructor stub
		size = capacity;
	}

	public int get(int key) {
		if(memory.containsKey(key)) {
			q.remove(key);
			q.add(key);
			return memory.get(key);
		}else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if(size == count) {
			//LRU
			memory.remove(q.poll());
			memory.put(key, value);
			q.add(key);
		}else {
			memory.put(key, value);
			count++;
			q.add(key);
		}
	}
	
	public static void main(String[] args) {
		LRU cache = new LRU(2);
		cache.put(1,1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		cache.get(2);
		cache.put(4, 4);
		
	}
}
