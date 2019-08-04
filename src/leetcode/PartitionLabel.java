package leetcode;
import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {
	public List<Integer> partitionLabels(String S) {
		int l = S.length();
		List<Integer> list =  new ArrayList();
		int[] index = new int[26];
		for(int i=l-1;i>=0;i--) {
			if(index[S.charAt(i)-97]==0) {
				index[S.charAt(i)-97]=i;
			}
		}
//		for(int i=0;i<26;i++) {
//			System.out.println(index[i]);
//		}
		int pointer = 0;
		int pos = 0;
		for(int i=0;i<l;i++) {
			char tmp = S.charAt(i);
			pos = Math.max(index[tmp-97],pos);
			if(pos==i) {
				list.add(index[tmp-97]+1-pointer);
				pointer = i+1;
			}
			
		}
		return list;
	}
	
	public static void main(String[] args) {
		PartitionLabel pl = new PartitionLabel();
		String S = "ababcbacadefegdehijhklij";
		List<Integer> ans = new ArrayList();
		ans = pl.partitionLabels(S);
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
