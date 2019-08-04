package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Fruit {
	public int totalFruit(int[] tree) {
		int l = tree.length;
		int maxNum = 0;
		int type1 = -1;//first bag
		int type2 = -1;//second bag
		int count = 0;
		int symbol = 0;
		List<Integer> list = new ArrayList();
		for(int i=0;i<l;i++) {
			//System.out.println(i);
			if(type1 == -1) {
				type1 = tree[i];
				count++;
				continue;
			}
			if(tree[i]==type1) {
				count++;
				continue;
			}
			if(tree[i]!=type1) {//first bag is full
				if(type2==-1) {
					symbol = i;
					type2 = tree[i];
					count++;
					continue;
				}else {
					if(tree[i]==type2) {
						count++;
						continue;
					}else {//both bags are full
						list.add(count);//backtrack
						i = symbol-1;
						count = 0;
						type1 = -1;
						type2 = -1;
						continue;
					}
				}
			}
		}
		list.add(count);
		for(int i=0;i<list.size();i++) {
			if(list.get(i)>maxNum) {
				maxNum = list.get(i);
			}
		}
		return maxNum;
	}
	
	public static void main(String[] args) {
		int[] tree = new int[] {3,3,3,1,2,1,1,2,3,3,4};
		Fruit f = new Fruit();
		System.out.println(f.totalFruit(tree));
	}
}
