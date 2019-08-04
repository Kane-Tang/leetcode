package leetcode;

import java.util.HashMap;

public class SubArray {
	public int subarraySum(int[] nums, int k) {
//		int l = nums.length;
//		// quickSort(nums, 0, l-1);
//		int sum = 0;
//		int ans = 0;
//		for (int i = 0; i < l; i++) {
//			sum = 0;
//			for (int j = i; j < l; j++) {
//				sum = sum + nums[j];
//				// System.out.println(sum);
//				if (sum == k) {
//					ans++;
//				}
//			}
//		}
//		return ans;
		
//		int count = 0;
//        int[] sum = new int[nums.length + 1];
//        sum[0] = 0;
//        for (int i = 1; i <= nums.length; i++)
//            sum[i] = sum[i - 1] + nums[i - 1];
//        for (int start = 0; start < nums.length; start++) {
//            for (int end = start + 1; end <= nums.length; end++) {
//                if (sum[end] - sum[start] == k)
//                    count++;
//            }
//        }
//        return count;
        
        int count = 0;
        int sum = 0;
        int l = nums.length;
        HashMap<Integer, Integer> hm = new HashMap();
        //key is the sum, value is the time of occurance
        hm.put(0, 1);//initialization
        for(int i=0;i<l;i++) {
        	sum += nums[i];
        	if(hm.containsKey(sum-k)) {//find res
        		count += hm.get(sum-k);
        	}
        	hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return count;
	}
	
//	public void quickSort(int[] nums, int low, int high) {
//		if(low<high) {
//			int par = partitions(nums, low, high);
//			quickSort(nums, low, par-1);
//			quickSort(nums, par+1, high);
//		}
//	}
//	
//	public int partitions(int[] nums, int low, int high) {
//		int par = nums[high];
//		int i = low-1;
//		for(int j=low;j<high;j++) {
//			if(nums[j]<par) {
//				i++;
//				int temp = nums[j];
//				nums[j] = nums[i];
//				nums[i] = temp;
//			}
//		}
//		
//		int temp = nums[i+1];
//		nums[i+1] = nums[high];
//		nums[high] = temp;
//		return i+1;
//	}
	
	public static void main(String[] args) {
		SubArray sa = new SubArray();
		int[] nums = new int[] {1,1,2,3,5,4,6};
		System.out.println(sa.subarraySum(nums, 4));
	}
}
