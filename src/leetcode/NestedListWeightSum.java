package leetcode;

import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedListWeightSum {

	public NestedListWeightSum() {
		// TODO Auto-generated constructor stub
	}
	
//	public int depthSumInverse(List<NestedInteger> nestedList) {
//        return helper(nestedList, 0);
//    }
//    
//    private int helper(List<NestedInteger> niList, int prev) {
//        int intSum = prev;
//        List<NestedInteger> levelBreak = new ArrayList<>();
//        
//        for (NestedInteger ni : niList) {
//            if (ni.isInteger()) {
//                intSum += ni.getInteger();
//            } else {
//                levelBreak.addAll(ni.getList());
//            }
//        }
//        
//        int listSum = levelBreak.isEmpty()? 0 : helper(levelBreak, intSum);
//
//        return listSum + intSum;
//    }

}
