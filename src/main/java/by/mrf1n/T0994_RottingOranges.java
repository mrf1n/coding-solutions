package by.mrf1n;

import java.util.LinkedList;
import java.util.Queue;

public class T0994_RottingOranges {
    public static void main(String[] args) {
        int[][] grid0 = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new T0994_RottingOranges().orangesRotting(grid0));
        int[][] grid1 = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(new T0994_RottingOranges().orangesRotting(grid1));
    }

    public int orangesRotting(int[][] grid) {
        int time = 0;
        Queue<Item> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Item(i, j - 1, 1));
                    queue.add(new Item(i, j + 1, 1));
                    queue.add(new Item(i - 1, j, 1));
                    queue.add(new Item(i + 1, j, 1));
                }
            }
        }
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            if (isInArray(grid, item.x, item.y) && grid[item.x][item.y] == 1) {
                queue.add(new Item(item.x, item.y - 1, item.expTime + 1));
                queue.add(new Item(item.x, item.y + 1, item.expTime + 1));
                queue.add(new Item(item.x - 1, item.y, item.expTime + 1));
                queue.add(new Item(item.x + 1, item.y, item.expTime + 1));
                time = item.expTime;
                grid[item.x][item.y] = 2;
            }
        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    time = -1;
                    break;
                }
            }
        }
        return time;
    }

    public boolean isInArray(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[x].length;
    }

    static class Item {
        int x;
        int y;
        int expTime;

        public Item(int x, int y, int expTime) {
            this.x = x;
            this.y = y;
            this.expTime = expTime;
        }
    }
}
