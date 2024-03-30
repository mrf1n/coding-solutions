package com.github.mrf1n;

import com.github.mrf1n.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class T0116_PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Node nodeMain = new Node();
        System.out.println(new T0116_PopulatingNextRightPointersInEachNode().connect(nodeMain));
    }

    public Node connect(Node node) {
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
