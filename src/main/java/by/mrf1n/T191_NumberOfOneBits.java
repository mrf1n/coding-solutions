package by.mrf1n;

public class T191_NumberOfOneBits {
    public static void main(String[] args) {
        int[] nums0 = new int[]{-16, -1, 0, 1, 2, 3, 4, 5, 6, 16, 32, 129};
        for (int num : nums0) {
            System.out.println(num);
            System.out.println(new T191_NumberOfOneBits().hammingWeight(num));
        }
    }

    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                weight++;
            }
            n >>>=1;
        }
        return weight;
    }
}
