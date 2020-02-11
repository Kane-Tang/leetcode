package leetcode;

public class MergeBinaryTree {
	public MergeBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	private TreeNode root;

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		//bfs
		if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
//		int val = 0;
//		if(t1!=null) {
//			val+=t1.val;
//		}
//		if(t2!=null) {
//			val+=t2.val;
//		}
//		root = new TreeNode(val);
//        if(t1 == null && t2 == null){
//            return null;
//        }
//        if(t1==null){
//            root.left = buildTree(null, t2.left);
//		    root.right = buildTree(null, t2.right);
//		    return root;
//        }
//        if(t2==null){
//            root.left = buildTree(t1.left, null);
//		    root.right = buildTree(t1.right, null);
//		    return root;
//        }
//		root.left = buildTree(t1.left, t2.left);
//		root.right = buildTree(t1.right, t2.right);
//		return root;
	}
	
	public TreeNode buildTree(TreeNode t1, TreeNode t2) {
		int val = 0;
        TreeNode node = new TreeNode(0);
		if(t1==null && t2==null) {
			return null;
		}else if(t1==null) {
			val = t2.val;
			node.val = val;
			if(t2.left!=null) {
				node.left = buildTree(null, t2.left);
			}
			if(t2.right!=null) {
				node.right = buildTree(null, t2.right);
			}
		}else if(t2==null) {
			val = t1.val;
			node.val = val;
			if(t1.left!=null) {
				node.left = buildTree(t1.left, null);
			}
			if(t1.right!=null) {
				node.right = buildTree(t1.right, null);
			}
		}else {
			val = t1.val+t2.val;
			node.val = val;
            System.out.println(val);
			if(t1.left!=null || t2.left!=null)
				node.left = buildTree(t1.left, t2.left);
			if(t1.right!=null || t2.right!=null)
				node.right = buildTree(t1.right, t2.right);
		}
        return node;
	}
	
}
