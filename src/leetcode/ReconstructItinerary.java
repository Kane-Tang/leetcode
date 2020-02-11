package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	public List<String> findItinerary(List<List<String>> tickets) {
//		List<String> list = new ArrayList();
//		int l = tickets.size();
//		list.add("JFK");
//		int count = 1;
//		//find departure
//		while(count<l+1) {
//			String dep = list.get(list.size()-1);
//			String des = "";
//			for(List<String> data: tickets) {
//				if(data.contains(dep)) {
//					if(data.get(0).equals(dep)) {
//						if(!list.contains(data.get(1))) {
//							des = data.get(1);
//						}else {
//							continue;
//						}
//					}else {
//						if(!list.contains(data.get(0))) {
//							des = data.get(0);
//						}else {
//							continue;
//						}
//						
//					}
//					break;
//				}
//			}
//			list.add(des);
//			count++;
//		}
//		return list;
		
		//recursion try
		//according to dfs
		//dfs
		LinkedList<String> list = new LinkedList();
		HashMap<String, PriorityQueue<String>> graph = new HashMap();
		for(List<String> edge: tickets) {
			if(!graph.containsKey(edge.get(0))) {
				graph.put(edge.get(0), new PriorityQueue());
			}
			graph.get(edge.get(0)).offer(edge.get(1));
		}
		dfs("JFK", graph, list);
		return list;
	}
	
	public void dfs(String node, HashMap<String, PriorityQueue<String>> graph, LinkedList<String> list) {
		PriorityQueue<String> nodes = graph.get(node);
		while(nodes!=null && !nodes.isEmpty()) {
			dfs(nodes.poll(), graph, list);//remove it once we visit one edge
		}
		//we need to *remove the edges* once it is visited. Thats why the solution uses a priority queue which sorts the nodes as well as helps in removing it in an efficient way
		//instance: 
		//jfk->atl,sfo
		//sfo->atl
		//atl->jfk,sfo
		list.addFirst(node);
	}
}
