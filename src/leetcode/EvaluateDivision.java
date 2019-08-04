package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int l = equations.size();
		
		HashMap<String, List<String>> var = new HashMap();
		HashMap<String, List<Double>> val = new HashMap();
		for(int i=0;i<l;i++) {
			List<String> e = equations.get(i);
			double v = values[i];
			
			//deal with the variables
			List<String> tmp1 = var.get(e.get(0));
			if(tmp1 == null) {
				//not exist
				tmp1 = new ArrayList();
				var.put(e.get(0), tmp1);
			}
			tmp1.add(e.get(1));
			
			tmp1 = var.get(e.get(1));
			if(tmp1 == null) {
				tmp1 = new ArrayList();
				var.put(e.get(1), tmp1);
			}
			tmp1.add(e.get(0));
			
			//deal with the values in corresponding order
			List<Double> tmp2 = val.get(e.get(0));
			if(tmp2 == null) {
				//not exist
				tmp2 = new ArrayList();
				val.put(e.get(0), tmp2);
			}
			tmp2.add(v);
			
			tmp2 = val.get(e.get(1));
			if(tmp2 == null) {
				tmp2 = new ArrayList();
				val.put(e.get(1), tmp2);
			}
			tmp2.add(1/v);
		}
		
		double[] ans = new double[queries.size()];
		for(int i=0;i<queries.size();i++) {
			if(!var.containsKey(queries.get(i).get(0)) || !var.containsKey(queries.get(i).get(1))) {
				ans[i] = -1.0;//not valid
			}else {
				double d = findAns(var, val, queries.get(i).get(0), queries.get(i).get(1), new ArrayList(), 1.0);
				if(d == 0.0) {
					ans[i] = -1.0;
				}else {
					ans[i] = d;
				}
				
			}
		}
		
		return ans;
	} 
	
	public double findAns(HashMap<String, List<String>> var, HashMap<String, List<Double>> val, String start, String end, List<String> visited, double value) {
//		Iterator<Map.Entry<String, List<String>>> iterator = var.entrySet().iterator();
//		if(start.equals(end)) {
//			return value;
//		}
//		double d = 0.0;
//		visited.add(start);
//		while(iterator.hasNext()) {
//			Map.Entry<String, List<String>> entry = iterator.next();
//			if(entry.getKey() == start) {
//				//find match
//				List<String> tmp = entry.getValue();
//				int index = 0;
//				for(String s: tmp) {
//					double v = val.get(start).get(index++);
//					if(!visited.contains(s)) {
//						d = findAns(var, val, s, end, visited, value*v);
//						if(d!=0) {
//							break;
//						}
//					}
//				}
//				break;
//			}
//		}
//		return d;
		if (start.equals(end))
            return value;
        visited.add(start);
        int i = 0;
        double d = 0.0;
        for (String n : var.get(start)) {
            double v = val.get(start).get(i++);
            if (!visited.contains(n)) {
                d = findAns(var, val, n, end, visited, value * v);
                if (d != 0)
                    break;
            }
        }
        return d;
		
	}
	
//
//    private static Double dfs(String start, String end, Map<String, List<String>> nodeGraph, Map<String, List<Double>> valueGraph, HashSet<String> visited, double value) {
//        if (start.equals(end))
//            return value;
//        visited.add(start);
//        int i = 0;
//        double d = 0.0;
//        for (String n : nodeGraph.get(start)) {
//            double v = valueGraph.get(start).get(i++);
//            if (!visited.contains(n)) {
//                d = dfs(n, end, nodeGraph, valueGraph, visited, value * v);
//                if (d != 0)
//                    break;
//            }
//        }
//        return d;
//    }
}
