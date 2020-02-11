package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

public class AlphabetBroadPath {

	public AlphabetBroadPath() {
		// TODO Auto-generated constructor stub
	}
	private int currentRow = 0;
	private int currentCol = 0;
	public String alphabetBoardPath(String target) {
		int l = target.length();
		StringBuilder ans = new StringBuilder();
		String[] board = new String[] { "abcde", "fghij", "klmno", "pqrst", "uvwxy", "z" };
		int r = 0;
		int c = 0;
		for (int i = 0; i < l; i++) {
			StringBuilder tmp = new StringBuilder();
			for(int j=0;j<board.length;j++) {
				int index = board[j].indexOf(target.charAt(i));
				if(index == -1) {
					continue;
				}else {
					r = j;
					c = index;
					break;
				}
			}
			tmp.append(findPath(r, c));
			ans.append(tmp);
		}
		return ans.toString();

	}

	public String findPath(int r, int c) {
		if(r == currentRow && c == currentCol) {
			return "!";
		}
		String path = "";
		if(r < currentRow) {
			currentRow -= 1;
			path += "U"+findPath(r,c);
		}
		if(c < currentCol) {
			currentCol -= 1;
			path += "L"+findPath(r,c);
		}
		if(r > currentRow) {
			currentRow += 1;
			path += "D"+findPath(r,c);
		}
		if(c > currentCol) {
			currentCol += 1;
			path += "R"+findPath(r,c);
		}
		return path;
//		Deque<HashMap<Pair<Integer, Integer>, String>> queue = new LinkedList();
//		HashMap<Pair<Integer, Integer>, String> hm = new HashMap();
//		hm.put(new Pair(r,c), "");
//		queue.add(hm);
//		int[][] visited = new int[board.length][board[0].length()];
//		while(!queue.isEmpty()) {
//			HashMap data = queue.poll();
//			Iterator<Map.Entry<Pair<Integer, Integer>, String>> iterator = data.entrySet().iterator();
//			
//			int a = iterator.next().getKey().getKey();
//			int b = iterator.next().getKey().getValue();
//			String path = iterator.next().getValue();
//			if (a < 0 || a >= board.length || b < 0 || b >= board[a].length()) {
//				continue;
//			}
//			if(visited[a][b]!=0) {
//				continue;
//			}
//			visited[a][b] = 1;
//			if(board[a].charAt(b)==t) {
//				tmp.append("!");
//				return;
//			}
//			//left
//			if(visited[r][c-1] == 0) {
//				HashMap<Pair<Integer, Integer>, String> insert = new HashMap();
//				StringBuilder sb = new StringBuilder();
//				sb.append(path);
//				sb.append("L");
//				insert.put(new Pair(r,c-1), sb.toString());
//				queue.add(insert);
//			}
//			//right
//			if(visited[r][c+1] == 0) {
//				HashMap<Pair<Integer, Integer>, String> insert = new HashMap();
//				StringBuilder sb = new StringBuilder();
//				sb.append(path);
//				sb.append("R");
//				insert.put(new Pair(r,c+1), sb.toString());
//				queue.add(insert);
//			}
//			//up
//			if(visited[r-1][c] == 0) {
//				HashMap<Pair<Integer, Integer>, String> insert = new HashMap();
//				StringBuilder sb = new StringBuilder();
//				sb.append(path);
//				sb.append("U");
//				insert.put(new Pair(r-1,c), sb.toString());
//				queue.add(insert);
//			}
//			//down
//			if(visited[r+1][c] == 0) {
//				HashMap<Pair<Integer, Integer>, String> insert = new HashMap();
//				StringBuilder sb = new StringBuilder();
//				sb.append(path);
//				sb.append("D");
//				insert.put(new Pair(r+1,c), sb.toString());
//				queue.add(insert);
//			}
//		}
	}

	public static void main(String[] args) {
		AlphabetBroadPath abp = new AlphabetBroadPath();
		System.out.println(abp.alphabetBoardPath("leet"));
	}
}
