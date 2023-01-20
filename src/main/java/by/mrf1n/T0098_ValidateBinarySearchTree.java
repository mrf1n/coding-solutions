package by.mrf1n;

import by.mrf1n.common.TreeNode;

public class T0098_ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(new T0098_ValidateBinarySearchTree().isValidBST(root0));
        TreeNode root1 = new TreeNode(2);
        System.out.println(new T0098_ValidateBinarySearchTree().isValidBST(root1));
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(new T0098_ValidateBinarySearchTree().isValidBST(root2));
        TreeNode root3 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(new T0098_ValidateBinarySearchTree().isValidBST(root3));
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }
}
