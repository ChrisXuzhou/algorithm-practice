package sortandsearch;

public class RotatedSortedArray {

    // todo Given a rotated sorted array, find a target element in the array.
    // return the index
    public int find(int[] array, int ele) {


        // find the pivot
        int pivot = 0;
        while (pivot < array.length -1) {
            if (array[pivot] > array[pivot + 1]){
                break;
            }
            pivot ++;
        }

        // search separately
        int l = find(array, ele, 0, pivot);
        if (l > 0) {
            return l;
        }

        int r = find(array, ele, pivot + 1, array.length -1);
        if (r > 0) {
            return r;
        }

        return -1;
    }

    private int find(int[] array, int ele, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == ele) {
            return mid;
        }

        int ret1 = find(array, ele, start, mid-1);
        if (ret1 > 0) {
            return ret1;
        }

        int ret2 = find(array, ele, mid + 1, end);
        if (ret2 > 0) {
            return ret2;
        }

        return -1;
    }

}
