package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
//	/** Initialize your data structure here. */
//	private List<Integer> set;
//	private Random r = new Random();
//	public RandomizedSet() {
//		set = new ArrayList();
//	}
//
//	/**
//	 * Inserts a value to the set. Returns true if the set did not already contain
//	 * the specified element.
//	 */
//	public boolean insert(int val) {
//		if(set.contains(val)) {
//			return false;
//		}
//		if(this.set.add(val)) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * Removes a value from the set. Returns true if the set contained the specified
//	 * element.
//	 */
//	public boolean remove(int val) {
//		if(set.contains(val)) {
//			int index = set.indexOf(val);
//			set.remove(index);
//			return true;
//		}else {
//			return false;
//		}
//	}
//
//	/** Get a random element from the set. */
//	public int getRandom() {
//		int l = this.set.size();
//		int index = this.r.nextInt(l);
//		return this.set.get(index);
//	}

	private Map<Integer, Integer> valueIndexMap;
	private List<Integer> valueList;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		valueIndexMap = new HashMap<Integer, Integer>();
		valueList = new ArrayList<Integer>();

	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (valueIndexMap.containsKey(val)) {
			return false;
		} else {
			valueList.add(val);
			valueIndexMap.put(val, valueList.size() - 1);
			return true;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 *
	 * Remove is the most tricky part, idea is rotate the targeting value to the end
	 * of the array, and delete it.
	 *
	 */
	public boolean remove(int val) {
		if (valueIndexMap.containsKey(val)) {
			int index = valueIndexMap.get(val);
			int lastIndex = valueList.size() - 1;

			// Update map and update array list;
			if (index == lastIndex) {
				valueIndexMap.remove(val);
				valueList.remove(lastIndex);
			} else {
				int lastValue = valueList.get(lastIndex);
				valueList.set(index, lastValue);
				valueIndexMap.put(lastValue, index);

				valueIndexMap.remove(val);
				valueList.remove(lastIndex);
			}

			return true;
		} else {
			return false;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int randIndex = new Random().nextInt(valueList.size());
		return valueList.get(randIndex);
	}
}
