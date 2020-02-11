package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

	public MovingAverage() {
		// TODO Auto-generated constructor stub
	}
	private int size = 0;
	private int count = 0;
	private int sum = 0;
	private Queue<Integer> queue = new LinkedList();
	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		this.size = size;
	}

	public double next(int val) {
		if(count >= size) {
			sum -= queue.poll();
			count--;
		}
		queue.add(val);
		count++;
		sum += val;
		return (double)sum/(double)count;
	}
}
