package by.mrf1n;

import by.mrf1n.common.TreeNode;

public class T0617_MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode root01 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode root02 = new TreeNode(2);
        System.out.println(new T0617_MergeTwoBinaryTrees().mergeTrees(root01, root02));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}
