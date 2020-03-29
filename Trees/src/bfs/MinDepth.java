package bfs;

import java.util.Deque;
import java.util.LinkedList;

public class MinDepth {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
		
		@Override
		public String toString() {
			
			return val+"";
		}
	}

	public int minDepth(TreeNode A) {

		if (A == null) {
			return 0;
		}

		Deque<TreeNode> q = new LinkedList<>();
		q.add(A);
		int levelNodes = 0;
		int minDepth = 0;

		while (!q.isEmpty()) {
			minDepth++;
			levelNodes = q.size();
			while (levelNodes-- > 0) {
				TreeNode temp = q.poll();

				if (temp.left == null && temp.right == null) {
					return minDepth;
				}
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}

		return minDepth;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = null;

		root.right.left = null;
		root.right.right = new TreeNode(5);

		MinDepth min = new MinDepth();
		System.out.println(min.minDepth(root));
	}

}
