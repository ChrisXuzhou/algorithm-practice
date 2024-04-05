package sortandsearch;

public class Sort {

    public void mergesort(int[] array) {


    }

    private void doMergesort(int[] array, int low, int high) {

        if (low >= high) return ;

        // todo
        int middle = (low + high) / 2;

        doMergesort(array, low, middle);
        doMergesort(array, middle + 1, high);

        int[] newArray = new int[array.length];
        int k = 0;
        int i = low;
        int j = middle + 1;

        while (i <= middle && j <= high) {
            if (array[i] < array[j]) {
                newArray[k++] = array[i++];
            } else {
                newArray[k++] = array[j++];
            }
        }

        // todo Copy remaining elements of the left subarray, if any
        while (i <= middle) {
            array[k] = newArray[i];
            i++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        new Sort().quickSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

    public void quickSort(int[] array) {
        doQuickSort(array, 0, array.length-1);
    }

    private void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void doQuickSort(int[] array, int start, int end) {

        if (start >= end) {
            return;
        }

        int _start = start;
        int _end = end;

        int pivot = end;
        end -= 1;

        while (start <= end) {
            while (array[start] < array[pivot] && start <= end) {
                start++;
            }
            while (array[end] > array[pivot] && start < end) {
                end--;
            }
            if (start < end) {
                swap(array, start, end);
            } else {
                // end of the loop
                swap(array, start, pivot);
                break;
            }
        }

        doQuickSort(array, _start, start -1);
        doQuickSort(array, start + 1, _end);
    }

}
