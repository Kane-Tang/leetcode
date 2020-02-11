package leetcode;

public class SecondMinimunNode {

	public SecondMinimunNode() {
		// TODO Auto-generated constructor stub
	}

	int min = 0;
	int ans = -1;
	public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
		traverse(root);
		return ans;
	}
	
	public void traverse(TreeNode node) {
		if(node == null) {
			return;
		}
		if(node.val<min) {
			min = node.val;
		}
		if(node.val > min && (node.val < ans||ans==-1)) {
			ans = node.val;
		}
		traverse(node.left);
		traverse(node.right);
	}

}
