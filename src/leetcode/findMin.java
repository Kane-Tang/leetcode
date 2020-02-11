package leetcode;

import java.util.ArrayList;
import java.util.List;

public class findMin {

	public findMin() {
		// TODO Auto-generated constructor stub
	}
	public String getMinVersion(String[] list) {
		List<Integer> tmp = new ArrayList();
        for(String s: list) {
        	String[] data = s.split("\\.");
        	if(tmp.size()==0) {
        		for(String d: data) {
        			tmp.add(Integer.parseInt(d));
        		}
        	}else {
        		int p = 0;
        		boolean flag = false;
        		while(p < tmp.size() && p < data.length) {
        			int n1 = tmp.get(p);
        			int n2 = Integer.parseInt(data[p]);
        			if(n2 < n1) {
        				//choose the new String
        				//System.out.println(n2+" "+n1);
        				flag = true;
        				break;
        			}else if(n2 == n1){
        				p++;
        				continue;
        			}else {
        				break;
        			}
        		}
        		if(flag == true) {
        			tmp.clear();
        			for(String d: data) {
        				tmp.add(Integer.parseInt(d));
        			}
        		}
        	}
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<tmp.size();i++) {
        	ans.append(tmp.get(i));
        	if(i != tmp.size()-1) {
        		ans.append(".");
        	}
        }
        return ans.toString();
    }
	
	public static void main(String[] args) {
		findMin fm = new findMin();
		String[] list = new String[] {"3", "4.3", "5.4", "2.10.3", "2.4"};
		System.out.println(fm.getMinVersion(list));
	}
}
