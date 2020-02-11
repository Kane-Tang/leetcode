package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Codec {
	
	public StringBuilder postorder(TreeNode root, StringBuilder sb) {
	    if (root == null) return sb;
	    postorder(root.left, sb);
	    postorder(root.right, sb);
	    sb.append(root.val);
	    sb.append(' ');
	    return sb;
	  }

	  // Encodes a tree to a single string.
	  public String serialize(TreeNode root) {
	    StringBuilder sb = postorder(root, new StringBuilder());
	    return sb.toString();
	  }

	  public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
	    if (nums.isEmpty()) return null;
	    int val = nums.getLast();
	    if (val < lower || val > upper) return null;

	    nums.removeLast();
	    TreeNode root = new TreeNode(val);
	    root.right = helper(val, upper, nums);
	    root.left = helper(lower, val, nums);
	    return root;
	  }

	  // Decodes your encoded data to tree.
	  public TreeNode deserialize(String data) {
	    if (data.equals("")) return null;
	    ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
	    for (String s : data.split("\\s+"))
	      nums.add(Integer.valueOf(s));
	    return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
	  }
	
//	private StringBuilder serial = new StringBuilder();
//	public Codec() {
//		// TODO Auto-generated constructor stub
//	}
//
//	// Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        //bfs
//    	List<TreeNode> list = new ArrayList();
//    	if(root==null) {
//    		return serial.toString();
//    	}
//    	list.add(root);
//    	traverse(list);
//    	return serial.toString();
//    }
//    
//    public void traverse(List<TreeNode> list) {
//    	if(list.isEmpty()) {
//    		return;
//    	}
//    	for(int i=0;i<list.size();i++) {
//        	serial.append(list.get(i).val+" ");
//    	}
//    	List<TreeNode> newList = new ArrayList();
//    	for(int i=0;i<list.size();i++) {
//    		TreeNode tmp = list.get(i);
//    		if(tmp.left==null) {
//    			newList.add(new TreeNode(-1));
//    		}
//    		if(tmp.left!=null) {
//    			newList.add(tmp.left);
//    		}
//    		if(tmp.right==null) {
//    			newList.add(new TreeNode(-1));
//    		}
//    		if(tmp.right!=null) {
//    			newList.add(tmp.right);
//    		}
//    	}
//    	traverse(newList);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        //level by level
//    	if(data.equals("")) {
//    		return null;
//    	}
//    	String[] value = data.split(" ");
//    	int pointer = 0;
//    	TreeNode root = new TreeNode(Integer.parseInt(value[0]));
//    	int level = 1;
//    	pointer++;
//    	List<TreeNode> list = new ArrayList();
//    	list.add(root);
//    	while(pointer < value.length) {
//    		List<TreeNode> update = new ArrayList();
//    		for(TreeNode tmp: list) {
//    			if(pointer>=value.length) {
//    				break;
//    			}
//    			if(value[pointer].equals("-1")) {
//    				tmp.left = null;
//    				pointer++;
//    			}else {
//    				tmp.left = new TreeNode(Integer.parseInt(value[pointer++]));
//    				update.add(tmp.left);
//    			}
//                if(pointer>=value.length) {
//    				break;
//    			}
//    			if(value[pointer].equals("-1")) {
//    				tmp.right = null;
//    				pointer++;
//    			}else {
//    				tmp.right = new TreeNode(Integer.parseInt(value[pointer++]));
//    				update.add(tmp.right);
//    			}
//    		}
//    		list = update;
//    	}
//    	return root;
//    }
}
