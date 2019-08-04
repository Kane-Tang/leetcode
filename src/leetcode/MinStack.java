package leetcode;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int x) {
		this.stack.push(x);
		if (this.minStack.isEmpty()) {
			this.minStack.push(x);
		} else {
			this.minStack.push(Math.min(this.minStack.peek(), x));
		}
	}

	public void pop() {
		this.stack.pop();
		this.minStack.pop();
	}

	public int top() {
		return this.stack.peek();
	}

	public int getMin() {
		return this.minStack.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
