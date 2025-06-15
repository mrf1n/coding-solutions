package com.github.mrf1n.coding.solutions;

import com.github.mrf1n.coding.solutions.common.TreeNode;

public class T0104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(new T0104_MaximumDepthOfBinaryTree().maxDepth(root0));
        TreeNode root1 = new TreeNode(2);
        System.out.println(new T0104_MaximumDepthOfBinaryTree().maxDepth(root1));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(new T0104_MaximumDepthOfBinaryTree().maxDepth(root2));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = maxDepth(root.left);
        }
        if (root.right != null) {
            right = maxDepth(root.right);
        }
        return Math.max(left, right) + 1;
    }
}
