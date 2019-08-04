package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ProblemTest {
	public static void main(String[] args) {
		List<List<Integer>> ans = new ArrayList();
		List<Integer> item = new ArrayList();
		item.add(3);
		ans.add(item);
		item.remove(0);
		System.out.println(ans);
	}
}
