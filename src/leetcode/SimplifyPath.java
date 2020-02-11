package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

	public SimplifyPath() {
		// TODO Auto-generated constructor stub
	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
	    String[] p = path.split("/");
	    for (int i = 0; i < p.length; i++) {
	        if (!stack.empty() && p[i].equals(".."))
	            stack.pop();
	        else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
	            stack.push(p[i]);
	    }
	    List<String> list = new ArrayList(stack);
	    return "/"+String.join("/", list);
	}
}
