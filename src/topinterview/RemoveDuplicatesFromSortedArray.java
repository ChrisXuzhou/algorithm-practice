package topinterview;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2};
        int ret =
                new RemoveDuplicatesFromSortedArray()
                        .removeDuplicates(array);

        System.out.println(ret);
        System.out.println(Arrays.toString(array));
    }

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

}
