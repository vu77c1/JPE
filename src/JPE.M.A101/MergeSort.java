import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // Example 1
        Integer[] array1 = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array 1: " + Arrays.toString(array1));

        Integer[] sortedArray1 = mergeSort(array1.clone());
        System.out.println("Sorted array 1: " + Arrays.toString(sortedArray1));

        // Example 2
        Integer[] array2 = {5, 8, 2, 10, 7, 15};
        System.out.println("Original array 2: " + Arrays.toString(array2));

        Integer[] result = maximum(array2);
        System.out.println("Max of array 2: " + result[0]);

    }
    private static void merge(Integer[] list, Integer[] left, Integer[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                list[k++] = left[i++];
            } else {
                list[k++] = right[j++];
            }
        }

        // Copy remaining elements from left, if any
        while (i < left.length) {
            list[k++] = left[i++];
        }

        // Copy remaining elements from right, if any
        while (j < right.length) {
            list[k++] = right[j++];
        }
    }
    public static Integer[] mergeSort(Integer[] list) {
        if (list.length <= 1) {
            return list; // Already sorted
        }

        // Split the array into two halves
        int mid = list.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[list.length - mid];

        System.arraycopy(list, 0, left, 0, mid);
        System.arraycopy(list, mid, right, 0, list.length - mid);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(list, left, right);

        return list;
    }
    public static Integer[] maximum(Integer[] list) {
        Integer[] sortedArray = mergeSort(list.clone());
        return new Integer[]{sortedArray[sortedArray.length - 1]}; // Return the last element (max)
    }

}

