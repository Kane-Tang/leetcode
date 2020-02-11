package leetcode;

import java.util.LinkedList;

public class MyHashMap {
	// Initialize is false
	boolean[] isExist;
	// Initialize a int array
	int[] intArray;

	/** Initialize your data structure here. */
	public MyHashMap() {
		isExist = new boolean[1000001];
		intArray = new int[1000001];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		intArray[key] = value;
		isExist[key] = true;
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		if (isExist[key] == true) {
			return intArray[key];
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		intArray[key] = -1;
		isExist[key] = false;
	}
}
