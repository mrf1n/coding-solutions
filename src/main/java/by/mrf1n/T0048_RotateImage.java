package by.mrf1n;

public class T0048_RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11}
                , {2, 4, 8, 10}
                , {13, 3, 6, 7}
                , {15, 14, 12, 16}};

        printMatrix(matrix);
        new T0048_RotateImage().rotate(matrix);
        printMatrix(matrix);

        matrix = new int[][]{
                {1, 2}
                , {3, 4}};

        printMatrix(matrix);
        new T0048_RotateImage().rotate(matrix);
        printMatrix(matrix);
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2 + matrix.length % 2; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
                matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = temp;

//                System.out.println(matrix.length - j - 1 + "," + i + " -> " + i + "," + j);
//                System.out.println((matrix.length - i - 1) + "," + (matrix.length - j - 1) + " -> " + (matrix.length - j - 1) + "," + i);
//                System.out.println(j + "," + (matrix.length - i - 1) + " -> " + (matrix.length - i - 1) + "," + (matrix.length - j - 1));
//                System.out.println(i + "," + j + " -> " + j + "," + (matrix.length - i - 1));
//                System.out.println();
//                printMatrix(matrix);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
