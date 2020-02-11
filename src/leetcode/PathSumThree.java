package leetcode;

public class PathSumThree {
	int count = 0;

	public int pathSum(TreeNode root, int sum) {
		if(root == null) {
			return count;
		}
		findAns(root, sum);
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		return count;
	}

	public void findAns(TreeNode node, int sum) {
		if (node == null) {
			return;
		}

		if (sum == node.val) {
			count++;
		}
		findAns(node.left, sum - node.val);
		findAns(node.right, sum - node.val);
	}
}
