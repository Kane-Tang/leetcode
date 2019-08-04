package leetcode;

import java.util.Scanner;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int length = nums.length;
		int ans = 0;
		for(int i=0;i<length;i++) {
			if(nums[i] != val) {
				nums[ans] = nums[i];
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] tmp = input.split(" ");
		int length = tmp.length;
		int[] nums = new int[length-1];
		for(int i=0;i<length-1;i++) {
			nums[i] = Integer.parseInt(tmp[i]);
		}
		int val = Integer.parseInt(tmp[length-1]);
		System.out.println(re.removeElement(nums, val));
	}
}
