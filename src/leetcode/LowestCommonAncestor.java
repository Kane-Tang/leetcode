package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//lowest level
		//All of the nodes' values will be unique.
//		List<TreeNode> ancestorOfP = new ArrayList();
//		List<TreeNode> ancestorOfQ = new ArrayList();
//		List<TreeNode> source = new ArrayList();
//		source.add(root);
//		findAns(source, p, q, ancestorOfP, ancestorOfQ);
//		for(int i=0;i<)
//		return ancestorOfP.get(0);
		
		// Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        //double ended queue

        // HashMap for parent pointers
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);
        
     // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        
     // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
	}
	
//	public void findAns(List<TreeNode> root, TreeNode p, TreeNode q, List<TreeNode> ancestorOfP, List<TreeNode>ancestorOfQ) {
//		//bfs
//		
//	}
}
