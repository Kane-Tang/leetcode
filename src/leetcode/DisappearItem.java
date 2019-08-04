package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DisappearItem {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList();
        int max = nums.length;
        if(max == 0) {
        	return ans;
        }
//        quickSort(nums, 0, max-1);
//        //eg: 1 2 2 3 3 4 7 8
//        for(int i=1;i<=max;i++) {
//        	if(nums[i-1] != i) {
//        		int j = i;//index
//        		if(nums[i-1] > i) {
//        			while(j>=0) {
//        				if(nums[j] != i) {
//        					j--;
//        				}else {
//        					break;
//        				}
//        			}
//        			if(j == -1) {
//        				ans.add(i);
//        			}
//        		}else {
//        			while(j<max) {
//            			if(nums[j] != i) {
//            				j++;
//            			}else {
//            				break;
//            			}
//            		}
//            		if(j == max && i!=max) {
//            			ans.add(i);
//            		}
//        		}
//        	}
//        }
        
        //save more time
        //eg: 1 2 2 3 3 4 7 8
        for(int i=0;i<max;i++) {
        	int val = Math.abs(nums[i])-1;
        	if(nums[val] > 0) {//if found, make it negative
        		nums[val] = -nums[val];
        	}else {
        		//System.out.println(nums[val]);
        	}
        }
        for(int i=0;i<max;i++) {
        	if(nums[i]>0) {//not found in the array
        		System.out.println(nums[i]);
        		ans.add(i+1);
        	}
        }
        return ans;
    }
	
	public void quickSort(int[] nums, int start, int end) {
		if(start<end) {
			int par = partitions(nums, start, end);
			quickSort(nums, start, par-1);
			quickSort(nums, par+1, end);
		}
	}
	
	public int partitions(int[] nums, int start, int end) {
		int par = nums[end];
		int i = start-1;
		for(int j=start;j<end;j++) {
			if(nums[j] < par) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		
		int tmp = nums[i+1];
		nums[i+1] = nums[end];
		nums[end] = tmp;
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,2,3,3,4,7,8};
		DisappearItem di = new DisappearItem();
		List<Integer> list = di.findDisappearedNumbers(nums);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i));
		}
	}
}
