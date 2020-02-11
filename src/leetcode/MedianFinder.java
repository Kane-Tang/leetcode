package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MedianFinder {

//	private LinkedList<Integer> list;
//
//	/** initialize your data structure here. */
//	public MedianFinder() {
//		list = new LinkedList();
//	}
//
//	public void addNum(int num) {
//		// keep order while inserting
//		if (list.size() == 0) {
//			list.add(num);
//			return;
//		}
//		for (int i = 0; i < list.size(); i++) {
//			//System.out.println(list.get(i));
//		}
//		//int tmp = list.remove(list.size() - 1);
//		//System.out.println(tmp);
//		LinkedList<Integer> check = new LinkedList();
//		while(list.get(list.size()-1)>num) {
//			int tmp = list.remove(list.size()-1);
//			check.add(tmp);
//			if(list.size()==0) {
//				break;
//			}
//		}
//		list.add(num);
//		for (int i = check.size()-1; i >= 0; i--) {
//			list.add(check.get(i));
//		}
////		if (tmp > num) {
////			check.add(tmp);
////			if (list.size() >= 1) {
////				while (tmp > num) {
////					if (list.size() == 0) {
////						break;
////					}
////					tmp = list.remove(list.size() - 1);
////					//System.out.println(tmp);
////					check.add(tmp);
////				}
////			}
////			list.add(num);
////			for (int i = check.size()-1; i >= 0; i--) {
////				list.add(check.get(i));
////			}
////		} else {
////			list.add(tmp);
////			list.add(num);
////		}
//		System.out.println("***********");
//	}
//
//	public double findMedian() {
////		for(int i=0;i<list.size();i++) {
////			System.out.println(list.get(i));
////		}
//		int l = list.size();
//		// quickSort(array, 0, l-1);
//		if (l % 2 == 0) {
//			double ans = 0.0;
//			ans = (double) (list.get(l / 2 - 1) + list.get(l / 2)) / 2;
//			return ans;
//		} else {
//			return list.get(l / 2);
//		}
//
//	}
//
//	public void quickSort(int[] nums, int low, int high) {
//		if (low < high) {
//			int par = partitions(nums, low, high);
//			quickSort(nums, low, par - 1);
//			quickSort(nums, par + 1, high);
//		}
//	}
//
//	public int partitions(int[] nums, int low, int high) {
//		int par = nums[high];
//		int i = low - 1;
//		for (int j = low; j < high; j++) {
//			if (nums[j] <= par) {
//				i++;
//				int tmp = nums[j];
//				nums[j] = nums[i];
//				nums[i] = tmp;
//			}
//		}
//		int tmp = nums[i + 1];
//		nums[i + 1] = nums[high];
//		nums[high] = tmp;
//		return i + 1;
//	}
	private List<Integer> list;
	/** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList();
    }
    
    public void addNum(int num) {
        if(list.isEmpty()) {
        	list.add(num);
        }else {
        	int index = find(num, 0, list.size()-1);
        	list.add(index, num);
        }
    }
    
    //bianry search
    public int find(int num, int begin, int end) {
    	int mid = (begin+end)/2;
    	int midValue = list.get(mid);
        if(num == midValue) {
        	return mid;
        }
        if(num < midValue){//left side
            int left = (mid == 0)? new Integer(Integer.MIN_VALUE): list.get(mid-1);
            if(num >= left) {
            	return mid;
            }
            return find(num,begin,mid-1);
        }else{//right side
            int right = (mid == list.size() -1)? new Integer(Integer.MAX_VALUE): list.get(mid+1);
            if(num <= right) {
            	return mid+1;
            }
            return find(num,mid+1,end);
        }
    }
	
    public double findMedian() {
    	int l = list.size();
		// quickSort(array, 0, l-1);
		if (l % 2 == 0) {
			double ans = 0.0;
			ans = (double) (list.get(l / 2 - 1) + list.get(l / 2)) / 2;
			return ans;
		} else {
			return list.get(l / 2);
		}

    }
    

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(6);
		mf.addNum(10);
		mf.addNum(2);
		mf.addNum(6);
		mf.addNum(5);
		mf.addNum(0);
		System.out.println(mf.findMedian());
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
