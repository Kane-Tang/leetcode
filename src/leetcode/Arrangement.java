package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//，学校希望通过搬出一部分学生的方法来改善这一问题。

//但是又因为教室数量有限，因此希望一个教室中容下的学生尽可能多，即需要搬出教室的学生数量尽可能少，请你输出搬出教室人数最少，且字典序最小的方案。
public class Arrangement {

	public Arrangement() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		HashMap<Integer, List<Integer>> relation = new HashMap();
		for(int i=0;i<m;i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			List<Integer> list = relation.getOrDefault(a, new ArrayList());
			list.add(b);
			relation.put(a, list);
//			List<Integer> list2 = relation.getOrDefault(b, new ArrayList());
//			list2.add(a);
//			relation.put(b, list2);
		}
		List<Integer> removeList = new ArrayList();
		for(int i=1;i<=n;i++) {
			if(remove(relation, i, removeList)) {
				System.out.println(removeList.size());
				for(int j=0;j<removeList.size();j++) {
					System.out.print(removeList.get(j)+" ");
				}
			}
		}
		
	}
	
	public static boolean remove(HashMap<Integer, List<Integer>> relation, int person, List<Integer> removeList) {
		Iterator<Map.Entry<Integer, List<Integer>>> iterator = relation.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer, List<Integer>> entry = iterator.next();
			if(entry.getKey()==person) {
				continue;
			}
			if(entry.getKey()!=null) {
				return false;
			}
		}
		removeList.add(person);
		return true;
	}

}
