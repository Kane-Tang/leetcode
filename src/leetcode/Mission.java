package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Mission {
	public static void main(String[] args){
//		输入包括N + M + 1行,
//		输入的第一行为两个正整数n和m(1 <= n, m <= 100000), 表示机器的数量和任务的数量。
//		接下来n行,每行两个整数zi和wi(0 < zi < 1000, 0 <= wi <= 100), 表示每台机器的最大工作时间和机器等级。
//		接下来的m行,每行两个整数xi和yi(0 < xi < 1000, 0 <= yi<= 100), 表示每个任务需要的完成时间和任务的难度等级。
		//如果完成这个任务将获得200 * xi + 3 * yi收益。
		//find the largest benefit
		Scanner sr = new Scanner(System.in);
		System.out.println("here");
		int n = sr.nextInt();//machine
		int m = sr.nextInt();//mission
		nodes[] e = new nodes[n];//machine
		nodes[] f = new nodes[m];//mission
		for (int i = 0; i < n; i++) {
			e[i] = new nodes(sr.nextInt(), sr.nextInt());
		}
		for (int i = 0; i < m; i++) {
			f[i] = new nodes(sr.nextInt(), sr.nextInt());
		}
		Comparator<nodes> cp = new Comparator<nodes>() {
			@Override
			public int compare(nodes a, nodes b) {
				return b.benefit - a.benefit;
			}
		};//large to small
		
		//sort from the highest benefit to the smallest
		Arrays.sort(e, cp);
		Arrays.sort(f, cp);

		long[] res = go(e, f, new long[2], 0);

		System.out.println(res[0] + " " + res[1]);
		//sr.close();
	}

	static long[] go(nodes[] e, nodes[] f, long[] oldres, int idx) {

		long bestRes[] = { oldres[0], oldres[1] };
		boolean found = false;
		for (int i = 0; i < e.length && e[i].benefit >= f[idx].benefit; i++) {
			if (e[i].occupied || e[i].t < f[idx].t || e[i].w < f[idx].w)
				continue;//can't execute
			found = true;
			long res[] = { oldres[0], oldres[1] };
			e[i].occupied = true;
			++res[0];
			res[1] += f[idx].benefit;
			if (idx + 1 < f.length)
				res = go(e, f, res, idx + 1);
			e[i].occupied = false;
			if (res[0] > bestRes[0] || (res[0] == bestRes[0] && res[1] > bestRes[1])) {
				bestRes[0] = res[0];
				bestRes[1] = res[1];
			}
		}
		if (!found && idx + 1 < f.length)
			bestRes = go(e, f, bestRes, idx + 1);
		return bestRes;
	}

}

class nodes {
	final int t;
	final int w;
	final int benefit;
	boolean occupied;

	nodes(int t, int w) {
		this.t = t;
		this.w = w;
		this.benefit = t * 200 + w * 3;
		this.occupied = false;
	}
}
