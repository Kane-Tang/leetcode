package leetcode;

import java.util.Stack;

public class MaxStack {
	/** initialize your data structure here. */
	private Stack<Integer> stack;
	private Stack<Integer> maxStack;

	public MaxStack() {
		stack = new Stack();
		maxStack = new Stack();
	}

	public void push(int x) {
		stack.push(x);
		// max stack
		int cur = 0;
		if (maxStack.isEmpty()) {
			cur = x;
		} else {
			cur = maxStack.peek();
		}
		maxStack.push(cur > x ? cur : x);
	}

	public int pop() {
		maxStack.pop();
		return stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	public int popMax() {
		int max = peekMax();
		//make changes in the oringinal stack
		Stack<Integer> buffer = new Stack();
        while (top() != max) {
        	buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
        	push(buffer.pop());
        }
        return max;
	}
}
