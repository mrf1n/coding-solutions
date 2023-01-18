package by.mrf1n;

public class T0190_ReverseBits {
    public static void main(String[] args) {
        int[] nums0 = new int[]{-16, -1, 0, 1, 2, 3, 4, 5, 6, 16, 32, 129};
        for (int num : nums0) {
            System.out.println(num);
            System.out.println(Integer.toBinaryString(num));
            System.out.println(new T0190_ReverseBits().reverseBits(num));
        }
    }

    public int reverseBits(int n) {
        int out = 0;
        for (int i = 0; i < 32; i++) {
            out <<= 1;
            out = out | n & 1;
            n >>= 1;
            System.out.println(Integer.toBinaryString(out));
        }
        return out;
    }
}
