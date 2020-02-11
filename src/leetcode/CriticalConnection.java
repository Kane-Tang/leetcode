package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CriticalConnection {

	public CriticalConnection() {
		// TODO Auto-generated constructor stub
	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		//build the map graph
		//HashMap<Integer, List<Integer>> graph = new HashMap();
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
		for(List<Integer> list: connections) {
			int node1 = list.get(0);
			int node2 = list.get(1);
			
			graph[node1].add(node2);
			graph[node2].add(node1);
//			graph.putIfAbsent(node1, new ArrayList());
//			List<Integer> newList = graph.get(node1);
//			newList.add(node2);
//			graph.put(node1, newList);
//			
//			graph.putIfAbsent(node2, new ArrayList());
//			List<Integer> newList2 = graph.get(node2);
//			newList2.add(node1);
//			graph.put(node2, newList2);
		}
		
		int[] timer = new int[n];
		boolean[] visit = new boolean[n];
		List<List<Integer>> res = new ArrayList();
		int timeStamp = 0;
		dfs(graph, timeStamp, timer, visit, -1, 0, res);
		return res;
	}
	
	public void dfs(List<Integer>[] graph, int timeStamp, int[] timer, boolean[] visit, int pre, int node, List<List<Integer>> res) {
		visit[node] = true;
		timer[node] = timeStamp++;
		int curTime = timer[node];
		
		List<Integer> neibours = graph[node];
		for(Integer n: neibours) {
			if(n == pre) {
				continue;
			}
			if(!visit[n]) {
				//dfs
				dfs(graph, timeStamp, timer, visit, node, n, res);
			}
			timer[node] = Math.min(timer[node], timer[n]);
			if(curTime < timer[n]) {
				List<Integer> list = new ArrayList();
				list.add(node);
				list.add(n);
				res.add(list);
			}
		}
	}
}
