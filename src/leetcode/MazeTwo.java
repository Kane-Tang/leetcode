package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeTwo {

	public MazeTwo() {
		// TODO Auto-generated constructor stub
	}
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		int res = 0;
		int sr = start[0];
		int sc = start[1];
		int dr = destination[0];
		int dc = destination[1];
		//bfs
		int[][] step = new int[maze.length][maze[0].length];
		for(int[] row: step) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		step[sr][sc] = 0;
		Queue<int[]> queue = new LinkedList();
		queue.add(start);
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0];
			int y = p[1];
			
			//move top
			int count = 0;
			x--;
			while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
				count++;
				x--;
			}
			if(step[p[0]][p[1]] + count < step[x+1][y]) {
				step[x+1][y] = step[p[0]][p[1]] + count;
				queue.add(new int[] {x+1, y});
			}
			//move down
			count = 0;
			x = p[0];
			y = p[1];
			x++;
			while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
				count++;
				x++;
			}
			if(step[p[0]][p[1]] + count < step[x-1][y]) {
				step[x-1][y] = step[p[0]][p[1]] + count;
				queue.add(new int[] {x-1, y});
			}
			//move left
			count = 0;
			x = p[0];
			y = p[1];
			y--;
			while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
				count++;
				y--;
			}
			if(step[p[0]][p[1]] + count < step[x][y+1]) {
				step[x][y+1] = step[p[0]][p[1]] + count;
				queue.add(new int[] {x, y+1});
			}
			//move right
			count = 0;
			x = p[0];
			y = p[1];
			y++;
			while(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
				count++;
				y++;
			}
			if(step[p[0]][p[1]] + count < step[x][y-1]) {
				step[x][y-1] = step[p[0]][p[1]] + count;
				queue.add(new int[] {x, y-1});
			}
		}
		if(step[dr][dc] == Integer.MAX_VALUE) {
			res = -1;
		}else {
			res = step[dr][dc];
		}
		return res;
	}
}
