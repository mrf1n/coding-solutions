package by.mrf1n;

import java.util.ArrayList;
import java.util.List;

public class T0119_RascalTriangle2 {

    public static void main(String[] args) {
        System.out.println(new T0119_RascalTriangle2().getRow(0));
        System.out.println(new T0119_RascalTriangle2().getRow(1));
        System.out.println(new T0119_RascalTriangle2().getRow(2));
        System.out.println(new T0119_RascalTriangle2().getRow(3));
        System.out.println(new T0119_RascalTriangle2().getRow(4));
        System.out.println(new T0119_RascalTriangle2().getRow(5));
        System.out.println(new T0119_RascalTriangle2().getRow(6));
        System.out.println(new T0119_RascalTriangle2().getRow(7));

        System.out.println(new T0119_RascalTriangle2().getRowRec(0));
        System.out.println(new T0119_RascalTriangle2().getRowRec(1));
        System.out.println(new T0119_RascalTriangle2().getRowRec(2));
        System.out.println(new T0119_RascalTriangle2().getRowRec(3));
        System.out.println(new T0119_RascalTriangle2().getRowRec(4));
        System.out.println(new T0119_RascalTriangle2().getRowRec(5));
        System.out.println(new T0119_RascalTriangle2().getRowRec(6));
        System.out.println(new T0119_RascalTriangle2().getRowRec(7));
    }

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<>();
        if (rowIndex < 0) {
            return row;
        }
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = row.size() - 2; j >= 0; j--) {
                row.set(j + 1, row.get(j) + row.get(j + 1));
            }
            row.add(1);
        }
        return row;
    }

    public List<Integer> getRowRec(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0) {
            return row;
        }

        List<Integer> prevRow = getRowRec(rowIndex - 1);
        for (int i = 0; i < prevRow.size() - 1; i++) {
            row.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        row.add(1);
        return row;
    }
}
