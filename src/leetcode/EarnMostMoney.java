package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EarnMostMoney {

	public EarnMostMoney() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String data = in.nextLine();
		String[] arr = data.split(" ");
		int[][] time = new int[arr.length][2];
		for(int i=0;i<arr.length;i++) {
			String tmp = arr[i];
			String[] check = tmp.split(",");
			int start = Integer.parseInt(check[0].substring(1));
			int end = Integer.parseInt(check[1].substring(0, check[1].length()-1));
			time[i][0] = start;
			time[i][1] = end;
		}
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o2[0]-o1[0];
				}else {
					return o1[1]-o2[1];
				}
			}
		});
		int t = 0;
		int count = 0;
		List<String> list = new ArrayList();
		for(int i=0;i<arr.length;i++) {
			int start = time[i][0];
			int end = time[i][1];
			if(start >= t) {
				count++;
				t = end;
				StringBuilder sb = new StringBuilder();
				sb.append("(").append(start).append(",").append(end).append(")").append(" ");
				list.add(sb.toString());
			}else {
				continue;
			}
		}
		System.out.println("count:"+count);
		StringBuilder ans = new StringBuilder();
		for(String s: list) {
			ans.append(s);
		}
		ans.deleteCharAt(ans.length()-1);
		System.out.println(ans);
	}
}
