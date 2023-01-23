package by.mrf1n;

import java.util.Arrays;

public class T0733_FloodFill {
    public static void main(String[] args) {
        int[][] image0 = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr0 = 1, sc0 = 1, newColor0 = 2;
        System.out.println(Arrays.deepToString(new T0733_FloodFill().floodFill(image0, sr0, sc0, newColor0)));
        int[][] image1 = new int[][]{{0, 0, 0}, {0, 1, 1}};
        int sr1 = 1, sc1 = 1, newColor1 = 1;
        System.out.println(Arrays.deepToString(new T0733_FloodFill().floodFill(image1, sr1, sc1, newColor1)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (newColor == color) {
            return image;
        }
        image[sr][sc] = newColor;
        if (sc > 0 && image[sr][sc - 1] == color) {
            floodFill(image, sr, sc - 1, newColor);
        }
        if (sr > 0 && image[sr - 1][sc] == color) {
            floodFill(image, sr - 1, sc, newColor);
        }
        if (sc < image[sr].length - 1 && image[sr][sc + 1] == color) {
            floodFill(image, sr, sc + 1, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == color) {
            floodFill(image, sr + 1, sc, newColor);
        }
        return image;
    }
}
