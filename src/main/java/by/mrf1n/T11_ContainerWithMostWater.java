package by.mrf1n;

public class T11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] tests0 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] tests1 = new int[]{1, 1};
        int[] tests2 = new int[]{};
        int[] tests3 = new int[]{2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxAreaBest(tests0));
        System.out.println(maxAreaBest(tests1));
        System.out.println(maxAreaBest(tests2));
        System.out.println(maxAreaBest(tests3));
    }

    public static int maxAreaSimple(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    public static int maxAreaIncorrectBest(int[] height) {
        int limitHeight = 10000, maxCurrentArea = 0, posL = 0, posR = height.length - 1;
        for (int i = 0, j = height.length - 1; j > i; i++, j--) {
            int maxAreaRight = (posR - i) * Math.min(height[i], height[posR]);
            int maxAreaLeft = (j - posL) * Math.min(height[posL], height[j]);
            if (maxAreaRight >= maxAreaLeft) {
                if (maxAreaRight > maxCurrentArea) {
                    posL = i;
                    maxCurrentArea = maxAreaRight;
                }
            } else {
                if (maxAreaLeft > maxCurrentArea) {
                    posR = j;
                    maxCurrentArea = maxAreaLeft;
                }
            }
            if ((j - i) * limitHeight < maxCurrentArea) {
                break;
            }
        }
        return maxCurrentArea;
    }

    public static int maxAreaBest(int[] height) {
        int limitHeight = 10000, maxArea = 0, i = 0, j = height.length - 1;
        while (j > i) {
            int currArea = (j - i) * Math.min(height[i], height[j]);
            if (currArea > maxArea) {
                maxArea = currArea;
            }
            if ((j - i) * limitHeight < maxArea) {
                break;
            }
            if (height[j] >= height[i]) {
                i++;
            } else {
                j--;
            }
//      System.out.println(i + " " + j + " , " + posL + " " + posR);
        }
        return maxArea;
    }
}
