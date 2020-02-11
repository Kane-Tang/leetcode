package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairs {

	public FindKPairs() {
		// TODO Auto-generated constructor stub
	}

	public class Pair{
        int x;
        int y;
        int sum;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
            this.sum=x+y;
        }
        public Pair(){}
    }
	
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> res = new ArrayList();
        
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return res;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.sum-p2.sum;
            }
        });
        
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                Pair p = new Pair(nums1[i], nums2[j]);
                pq.offer(p);
            }
        }
        
        if(k>=pq.size()) k=pq.size();
        
        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            List<Integer> list = new ArrayList();
            list.add(p.x);
            list.add(p.y);
            res.add(list);
        }
        return res;
    }
}
