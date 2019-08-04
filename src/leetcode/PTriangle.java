package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PTriangle {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ans = new ArrayList();
		ans.add(1);
		if(rowIndex==0) {
			return ans;
		}
		ans.add(1);
		if(rowIndex==1) {
			return ans;
		}
		for(int i=1;i<rowIndex;i++) {
			List<Integer> tmp = new ArrayList();
			tmp.add(1);
			int length = ans.size();
			for(int j=1;j<length;j++) {
				int entry = ans.get(j)+ans.get(j-1);
				tmp.add(entry);
			}
			tmp.add(1);
			ans = tmp;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		PTriangle pt = new PTriangle();
		List<Integer> list = new ArrayList();
		list = pt.getRow(4);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i));
		}
	}
}
