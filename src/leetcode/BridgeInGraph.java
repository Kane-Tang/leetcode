package leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BridgeInGraph {

	public BridgeInGraph() {
		// TODO Auto-generated constructor stub
	}
//	…..a) Remove (u, v) from graph
//	..…b) See if the graph remains connected (We can either use BFS or DFS)
//	…..c) Add (u, v) back to the graph.
	
	//not good enough
	//then
	//In DFS tree an edge (u, v) (u is parent of v in DFS tree) is bridge
	//if there does not exist any other alternative to reach u or an ancestor of u from subtree rooted with v.

//	In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
//	1) u is root of DFS tree and it has at least two children.
//	2) u is not root of DFS tree and it has a child v such that
//	no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.
	static final int NIL = -1;
	static List<Integer[]> ans1 = new LinkedList<>();
	static int time = 0;

	static class Graph {
		private int v;
		private LinkedList<Integer> adj[];

		Graph(int v) {
			this.v = v;
			adj = new LinkedList[v + 1];
			for (int i = 0; i <= v; i++) {
				adj[i] = new LinkedList();
			}
		}

		void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}
	}

	public static int[][] bridge(int[][] edges, int v) {
		Graph g = new Graph(v);
		for (int i = 0; i < edges.length; i++) {
			g.addEdge(edges[i][0], edges[i][1]);
		}
		boolean visited[] = new boolean[v + 1];
//		u is parent of v
//		low[u] = min(disc[u], disc[w]) 
//		where w is an ancestor of u and there is a back edge from 
//		some descendant of u to w.
		int[] disc = new int[v + 1];// store the discovery times of visited vertices
		int[] low = new int[v + 1];//low[v] indicates earliest visited vertex(the vertex with minimum discovery time)
		//reachable from subtree rooted with v.
		// The condition for an edge (u, v) to be a bridge is, “low[v] > disc[u]”.
		int[] parent = new int[v + 1];// store the parents vertices in dfs tree
		for (int i = 0; i < v; i++) {
			parent[i] = NIL;
			visited[i] = false;
		}

		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(g, i, visited, disc, low, parent);
			}
		}
		int[][] res = new int[ans1.size()][2];
		int index = 0;
		for (Integer[] tmp : ans1) {
			res[index][0] = tmp[0];
			res[index][1] = tmp[1];
			index++;
		}
		return res;
	}

	public static void dfs(Graph g, int p, boolean[] visited, int[] disc, int[] low, int[] parent) {
		visited[p] = true;
		disc[p] = low[p] = ++time;
		Iterator<Integer> i = (g.adj[p]).iterator();
		while(i.hasNext()) {
			int child = i.next();
			if(!visited[child]) {
				parent[child] = p;
				dfs(g, child, visited, disc, low, parent);
				low[p] = Math.min(low[p],low[child]);
				if(low[child]>disc[p]) {
					//bridge
					ans1.add(new Integer[] {p,child});
				}
			}else if(child != parent[p]) {
				low[p] = Math.min(low[p], disc[child]);
			}
		}
	}
	
	public static void main(String[] args) {
        //int n=9;
        int n=5;
        //int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
        int[][] edges = {{1,2},{1,3},{1,4},{3,4},{4,5}};
        int[][] ans = bridge(edges,n);
        if(ans.length==0) {
        	System.out.print("[]");
        }
            
        for(int[] arr : ans)
            System.out.print(Arrays.toString(arr)+",");
    }
}
