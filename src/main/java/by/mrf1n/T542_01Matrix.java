package by.mrf1n;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T542_01Matrix {
    public static void main(String[] args) {
        int[][] mat0 = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(new T542_01Matrix().updateMatrix(mat0)));
        int[][] mat1 = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(new T542_01Matrix().updateMatrix(mat1)));
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] out = new int[mat.length][mat[0].length];
        Queue<Item> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                if (mat[i][j] == 1) {
                    out[i][j] = -1;
                } else {
                    queue.add(new Item(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            nexStep(queue, item, out, item.x, item.y - 1);
            nexStep(queue, item, out, item.x, item.y + 1);
            nexStep(queue, item, out, item.x - 1, item.y);
            nexStep(queue, item, out, item.x + 1, item.y);
        }
        return out;
    }

    public void nexStep(Queue<Item> queue, Item item, int[][] out, int x, int y) {
        if (x >= 0 && y >= 0 && x < out.length && y < out[x].length && out[x][y] == -1) {
            queue.add(new Item(x, y, item.dist + 1));
            out[x][y] = item.dist + 1;
        }
    }

    class Item {
        int x;
        int y;
        int dist;

        public Item(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
