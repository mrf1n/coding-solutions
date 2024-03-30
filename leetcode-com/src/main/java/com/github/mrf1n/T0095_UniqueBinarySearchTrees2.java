package com.github.mrf1n;

import com.github.mrf1n.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T0095_UniqueBinarySearchTrees2 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new T0095_UniqueBinarySearchTrees2().generateTrees(n));
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int l, int r) {
        if (l > r) {
            List<TreeNode> bs = new ArrayList<>();
            bs.add(null);
            return bs;
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            for (TreeNode left : generateTrees(l, i - 1)) {
                for (TreeNode right : generateTrees(i + 1, r)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }

        }
        return result;
    }
}
