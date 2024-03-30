package com.github.mrf1n;

import com.github.mrf1n.common.TreeNode;

public class T0101_SymmetricTree {

    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(7)), new TreeNode(2, new TreeNode(7), new TreeNode(3)));
        System.out.println(new T0101_SymmetricTree().isSymmetric(root0));
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(7), new TreeNode(3)), new TreeNode(2, new TreeNode(7), new TreeNode(3)));
        System.out.println(new T0101_SymmetricTree().isSymmetric(root1));
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if ((left == null) == (right != null) || left != null && left.val != right.val) {
            return false;
        }
        return left == null || isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
