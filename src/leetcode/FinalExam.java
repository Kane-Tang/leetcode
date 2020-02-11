package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class FinalExam {

	public FinalExam() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		for (int k = 0; k < c; k++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] arr = new int[n];
			int total = 0;
			// TreeMap<Integer, Integer> count = new TreeMap();
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				// count.put(arr[i], i);
			}
			int[] res = new int[n];
			List<Integer> list = new ArrayList();
			for (int i = 0; i < n; i++) {
				if (m - total >= arr[i]) {
					res[i] = 0;
					total += arr[i];
					list.add(arr[i]);
				} else {
					// dont have enough time yet
					// greedy
					Collections.sort(list);
					int count = 0;
					int sum = 0;
					for (int j = list.size() - 1; j >= 0; j--) {
						sum += list.get(j);
						if (m - total + sum >= arr[i]) {
							res[i] = ++count;
							break;
						} else {
							count++;
						}
					}
					total += arr[i];
					list.add(arr[i]);
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}

	}
}
