package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Serialization {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		// bfs
//		List<TreeNode> list = new ArrayList();
//		list.add(root);
//		StringBuilder s = new StringBuilder();
//		return findAns(list, s);
		
		//dfs
		return rserialize(root, "");
	}
	
	public String rserialize(TreeNode root, String str) {
	    // Recursive serialization.
	    if (root == null) {
	      str += "null,";
	    } else {
	      str += str.valueOf(root.val) + ",";
	      str = rserialize(root.left, str);
	      str = rserialize(root.right, str);
	    }
	    return str;
	  }

	public String findAns(List<TreeNode> list, StringBuilder s) {
    		for(int i=0;i<list.size();i++) {
    			int val = list.get(i).val;
    			if(val == -1) {
    				s.append("null,");
    			}else {
        			s.append(val+",");
    			}
    		}
			//update the new list
    		int count = 0;//scan to decide whether we need to do the backtrack
    		for(int i=0;i<list.size();i++) {
    			TreeNode tmp = list.get(i);
    			if(tmp.val == -1) {
    				count++;
    			}
    		}
    		if(count == list.size()) {
    			return s.toString();
    		}else {
    			List<TreeNode> newlist = new ArrayList();
    			for(int i=0;i<list.size();i++) {
    				TreeNode tmp = list.get(i);
    				if(tmp.val == -1) {
    					newlist.add(new TreeNode(-1));
    					newlist.add(new TreeNode(-1));
    				}else {//not null
    					if(tmp.left != null) {
    						newlist.add(tmp.left);
    					}else {
    						newlist.add(new TreeNode(-1));
    					}
    					
    					if(tmp.right != null) {
    						newlist.add(tmp.right);
    					}else {
    						newlist.add(new TreeNode(-1));
    					}
    				}
    			}
    			findAns(newlist, s);
    		}
    		return "";
    }
	
	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
    
    public TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
    	//from dfs order
        if (l.get(0).equals("null")) {
          l.remove(0);
          return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
      }
}
