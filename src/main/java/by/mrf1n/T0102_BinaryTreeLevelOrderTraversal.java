package by.mrf1n;

import by.mrf1n.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T0102_BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(new T0102_BinaryTreeLevelOrderTraversal().levelOrder(root2));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subAns = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek() != null && queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek() != null && queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subAns.add(queue.poll().val);
            }
            res.add(subAns);
        }
        return res;
    }
}
