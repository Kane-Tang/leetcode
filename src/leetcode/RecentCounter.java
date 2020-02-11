package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

	Queue<Integer> queue;
	public RecentCounter() {
		// TODO Auto-generated constructor stub
		queue = new LinkedList();
	}

	public int ping(int t) {
		queue.add(t);
		while(t-queue.peek() > 3000) {
			queue.poll();
		}
		return queue.size();
	}

}
