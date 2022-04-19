package by.mrf1n;

public class T695_MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid0 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid0));
        int[][] grid1 = new int[][]{{0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0}};
        System.out.println(maxAreaOfIsland(grid1));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, getArea(grid, i, j));
                }
            }
        }
        return max;
    }

    public static int getArea(int[][] grid, int i, int j) {
        int area = 0;
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            area++;
        }
        if (i > 0 && grid[i - 1][j] == 1) {
            area += getArea(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            area += getArea(grid, i, j - 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            area += getArea(grid, i + 1, j);
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
            area += getArea(grid, i, j + 1);
        }
        return area;
    }
}
