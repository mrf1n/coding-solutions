package com.github.mrf1n.coding.solutions;

import com.github.mrf1n.coding.solutions.common.TreeNode;

public class T0700_SearchBinarySearchTree {

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        System.out.println(new T0700_SearchBinarySearchTree().searchBST(treeNode0, 2));
        System.out.println(new T0700_SearchBinarySearchTree().searchBST(treeNode0, 5));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        } else if (val > root.val && root.right != null) {
            return searchBST(root.right, val);
        } else if (val < root.val && root.left != null) {
            return searchBST(root.left, val);
        }
        return null;
    }
}
