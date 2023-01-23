package by.mrf1n;

import java.util.ArrayList;
import java.util.List;

public class T0118_PascalTriangle {

    public static void main(String[] args) {
        int numRows0 = 1;
        System.out.println(new T0118_PascalTriangle().generate(numRows0));
        int numRows1 = 5;
        System.out.println(new T0118_PascalTriangle().generate(numRows1));
        int numRows2 = 10;
        System.out.println(new T0118_PascalTriangle().generateLC(numRows2));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int r = 0; r < numRows; r++) {
            List<Integer> layerI = new ArrayList<>();
            if (r == 0) {
                layerI.add(1);
                triangle.add(layerI);
                continue;
            }
            for (int i = 0; i < r + 1; i++) {
                int item = 0;
                if (i - 1 >= 0) {
                    item += triangle.get(r - 1).get(i - 1);
                }
                if (i < r) {
                    item += triangle.get(r - 1).get(i);
                }
                layerI.add(item);

            }
            triangle.add(layerI);
        }
        return triangle;
    }

    public List<List<Integer>> generateLC(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        if (numRows <= 0) {
            return output;
        }

        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        output.add(prev);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            output.add(curr);
            prev = curr;
        }
        return output;
    }
}
