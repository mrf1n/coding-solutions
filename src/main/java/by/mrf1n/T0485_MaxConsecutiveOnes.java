package by.mrf1n;

public class T0485_MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr0 = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(new T0485_MaxConsecutiveOnes().findMaxConsecutiveOnes(arr0));
        int[] arr1 = new int[]{1, 0, 0, 1, 1, 0, 1};
        System.out.println(new T0485_MaxConsecutiveOnes().findMaxConsecutiveOnes(arr1));
        int[] arr2 = new int[]{1};
        System.out.println(new T0485_MaxConsecutiveOnes().findMaxConsecutiveOnes(arr2));
        int[] arr3 = new int[]{0};
        System.out.println(new T0485_MaxConsecutiveOnes().findMaxConsecutiveOnes(arr3));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int countOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            } else {
                maxOnes = Math.max(maxOnes, countOnes);
                countOnes = 0;
            }
        }
        return Math.max(maxOnes, countOnes);
    }
}
