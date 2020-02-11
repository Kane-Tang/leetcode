package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadders {

	public SnakeAndLadders() {
		// TODO Auto-generated constructor stub
	}

	public int snakesAndLadders(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		// bfs
		HashMap<Integer, Integer> step = new HashMap();
		Queue<Integer> queue = new LinkedList();
		step.put(1, 0);
		queue.add(1);

		while (!queue.isEmpty()) {
			int p = queue.poll();
			if (p == row * row) {
				return step.get(p);
			}

			for (int i = p + 1; i <= Math.min(p + 6, row * row); i++) {
				// get true coordinate in the matrix
				int pos = (i-1) / row;
				int rem = (i-1) % row;
				int tr = row - 1 - pos;
				int tc = 0;
				if(tr % 2 == row % 2) {
					tc = col-1-rem;
				}else {
					tc = rem;
				}
				int destination = board[tr][tc]==-1 ? i : board[tr][tc];
				if(!step.containsKey(destination)) {
					step.put(destination, step.get(p)+1);
					queue.add(destination);
				}
			}
		}
		
		return -1;
	}
}
