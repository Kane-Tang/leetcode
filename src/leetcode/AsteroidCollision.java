package leetcode;

import java.util.Stack;

public class AsteroidCollision {

	public AsteroidCollision() {
		// TODO Auto-generated constructor stub
	}

	public int[] asteroidCollision(int[] asteroids) {
		int l = asteroids.length;
		Stack<Integer> stack = new Stack();
		boolean flag = true;
		for(int ast: asteroids) {
			flag = true;
			while(!stack.isEmpty() && stack.peek()>0 && ast<0) {
				if(stack.peek() < -ast) {
					stack.pop();
					continue;
				}else if(stack.peek() == -ast) {
					stack.pop();
				}
				flag = false;
				break;
			}
			if(flag)
				stack.push(ast);
		}
		int[] ans = new int[stack.size()];
		for(int i=ans.length-1;i>=0;i--) {
			ans[i] = stack.pop();
		}
		return ans;
	}
}
