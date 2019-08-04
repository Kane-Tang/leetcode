package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		HashMap<Integer, Integer> hm = new HashMap();
//		int l = prerequisites.length;
//		for(int i=0;i<l;i++) {
//			hm.put(prerequisites[i][0], prerequisites[i][1]);
//		}
//		
//		List<Integer> courseList = new ArrayList();
//		courseList.add(prerequisites[0][0]);
//		courseList.add(prerequisites[0][1]);
//		for(int i=1;i<l;i++) {
//			
//		}
		
		final List<Integer>[] graph = new List[numCourses];//prerequisite courses for course i
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        return !hasCycle(graph, numCourses);//to check whether there is a cycle
	}
	
	private boolean hasCycle(final List<Integer>[] graph, int numCourses) {
        final boolean[] visited = new boolean[numCourses];
        final boolean[] onStack = new boolean[numCourses];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (hasCycle(i, graph, visited, onStack)) {
                    return true;
                }
            }
        }
        return false;
    }
	
	private boolean hasCycle(int v, final List<Integer>[] graph, final boolean[] visited, final boolean[] onStack) {
        visited[v] = true;
        onStack[v] = true;
        boolean hasCycle = false;
        for (int w : graph[v]) {
            if (!visited[w]) {
                hasCycle = hasCycle(w, graph, visited, onStack);
                if (hasCycle) {
                    break;
                }
            } else if (onStack[w]) {
                hasCycle = true;
                break;
            }
        }
        onStack[v] = false;
        return hasCycle;
    }
}
