package by.mrf1n;

import by.mrf1n.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class T116_PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {

    }

    public static Node conect(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node pNode = queue.poll();
                if (i < size - 1 && pNode != null) {
                    pNode.next = queue.peek();
                }
                if (pNode.left != null) {
                    queue.add(pNode.left);
                }
                if (pNode.right != null) {
                    queue.add(pNode.right);
                }
            }
        }
        return node;
    }
}
