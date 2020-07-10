package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressType {

	public AddressType() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String, List<String>> map = new HashMap();
		for(int i=0;i<n;i++) {
			String s = in.next();
			String address = s.split("//")[1].split("/")[0];
			if(s.split("//")[1].split("/").length == 1) {
				continue;
			}
			String path = s.split("//")[1].split("/")[1];
			//System.out.println(path);
			if(map.containsKey(address)) {
				List<String> list = map.get(address);
				if(!list.contains(path)) {
					list.add(path);
					map.put(address, list);
				}
			}else {
				List<String> list = new ArrayList();
				list.add(path);
				map.put(address, list);
			}
		}
		Set<String> res = new HashSet();
		Set<String> keys = map.keySet();
		String[] data = new String[keys.size()];
		int index = 0;
		for(String tmp: keys) {
			data[index++] = tmp;
		}
		for(int i=0;i<data.length;i++) {
			List<String> l1 = map.get(data[i]);
			for(int j=i+1;j<data.length;j++) {
				List<String> l2 = map.get(data[j]);
				boolean flag = true;
				if(l1.size() != l2.size()) {
					flag = false;
				}
				for(String tmp: l2) {
					if(!l1.contains(tmp)) {
						flag = false;
						break;
					}
				}
				if(flag == true) {
					res.add(data[i]+" "+data[j]);
				}
			}
		}
		System.out.println(res.size());
		for(String tmp: res) {
			System.out.println(tmp);
		}
	}
}
