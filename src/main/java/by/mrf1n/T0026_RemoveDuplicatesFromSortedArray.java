package by.mrf1n;

public class T0026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums0 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums1 = new int[]{0, 1, 2, 3, 4};
        System.out.println(new T0026_RemoveDuplicatesFromSortedArray().removeDuplicates(nums0));
        System.out.println(new T0026_RemoveDuplicatesFromSortedArray().countUnique(nums1));
    }

    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
               nums[count] = nums[i];
               count++;
            }
//            System.out.println(Arrays.toString(nums));
        }
        return count;
    }

    public int countUnique(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                count++;
//                System.out.println("Num [" + i + "] - " + nums[i]);
            }
        }
        return count;
    }
}
