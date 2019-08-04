package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DuplicatedFile {
	public List<List<String>> findDuplicate(String[] paths) {
		int l = paths.length;
		List<List<String>> list = new ArrayList();
		HashMap<String,List<String>> hm = new HashMap();
		for(int i=0;i<l;i++) {
			String[] content = paths[i].split(" ");//regex rule: '(' -> '\\('
			int s = content.length;
			String path = content[0];
			for(int j=1;j<s;j++) {
				String word = content[j].substring(content[j].indexOf('(')+1, content[j].indexOf(')'));
				String subPath = content[j].substring(0, content[j].indexOf('('));
				String fullPath = path+"/"+subPath;
				if(hm.containsKey(word)) {
					hm.get(word).add(fullPath);
				}else {
					hm.put(word, new ArrayList());
					hm.get(word).add(fullPath);
				}
			}
		}
		Iterator<Map.Entry<String,List<String>>> iterator = hm.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String,List<String>> entry = iterator.next();
//			List<String> tmp = new ArrayList();
//			tmp.add(entry.getValue());
			if(entry.getValue().size()>1)
				list.add(entry.getValue());
		}
		return list;
	}
	
	public static void main(String[] args) {
		DuplicatedFile df = new DuplicatedFile();
		String[] paths = new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		List<List<String>> ans = df.findDuplicate(paths);
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
	
	
}
