package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
	public class NestedIterator implements Iterator<Integer> {
		private List<Integer> flattenedList;
		private Iterator<Integer> it;

		public NestedIterator(List<NestedInteger> nestedList) {
		    flattenedList = new LinkedList<Integer>();
		    flatten(nestedList);
		    it = flattenedList.iterator();
		}

		private void flatten(List<NestedInteger> nestedList) {
		    for (NestedInteger i : nestedList) {
		        if (i.isInteger()) {
		            flattenedList.add(i.getInteger());
		        } else {
		            flatten(i.getList());
		        }
		    }
		}

		@Override
		public Integer next() {
		    return it.next();
		}

		@Override
		public boolean hasNext() {
		    return it.hasNext();
		}
		*/
//		NestedInteger nextInt;
//	    Stack<Iterator<NestedInteger>> stack;
//
//	    public NestedIterator(List<NestedInteger> nestedList) {
//	        stack = new Stack<Iterator<NestedInteger>>();
//	        stack.push(nestedList.iterator());
//	    }
//
//	    @Override
//	    public Integer next() {
//	        return nextInt != null ? nextInt.getInteger() : null; //Just in case
//	    }
//
//	    @Override
//	    public boolean hasNext() {
//	        while (!stack.isEmpty()) {
//	            if (!stack.peek().hasNext()) {
//	            	stack.pop();
//	            }
//	            else if ((nextInt = stack.peek().next()).isInteger()) {
//	            	return true;
//	            }
//	            else {
//	            	stack.push(nextInt.getList().iterator());
//	            }
//	        }
//	        return false;
//	    }
//	}

	/**
	 * Your NestedIterator object will be instantiated and called as such:
	 * NestedIterator i = new NestedIterator(nestedList);
	 * while (i.hasNext()) v[f()] = i.next();
	 */