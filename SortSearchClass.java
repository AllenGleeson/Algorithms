import java.util.Comparator;

public class SortSearchClass<T extends Comparable<? super T>> {

    // Bubble Sort
    public void bubbleSort(T[] array) { // o(n2)
        int n = array.length; // o(1)
        boolean swapped; // o(1)
        for (int i = 0; i < n - 1; i++) { // o(n)
            swapped = false; // o(1)
            for (int j = 0; j < n - i - 1; j++) { // o(n)
                if (array[j].compareTo(array[j + 1]) > 0) { // o(1)
                    T temp = array[j]; // o(1)
                    array[j] = array[j + 1]; // o(1)
                    array[j + 1] = temp; // o(1)
                    swapped = true; // o(1)
                }
            }
            // If no swaps on pass through then break early
            if (!swapped) // o(1)
                break; // o(1)
        }
    }

    // Quick Sort
    public void quickSort(T[] array) { // o(n log n)
        if (array == null || array.length == 0) // o(1)
            return; // o(1)
        quickSort(array, 0, array.length - 1); // o(log n)
    }

    private void quickSort(T[] array, int low, int high) { // o(n log n)
         // Base case for recursion
         if (array == null || array.length == 0 || low >= high) // o(1)
             return; // o(1)

         // Recursive case
         // Partitioning the array and sorting the subarrays
         // The partitioning step is o(n) and the recursive calls are o(log n)
        if (low < high) { // o(1)
            int pivotIndex = partition(array, low, high); // o(n)
            quickSort(array, low, pivotIndex - 1); // o(log n)
            quickSort(array, pivotIndex + 1, high); // o(log n)
        }
    }

    private int partition(T[] array, int low, int high) {  // o(n)
        // Choosing the last element as pivot
        T pivot = array[high]; // o(1)
        int i = low - 1; // o(1)
        // Rearranging the array elements
        // Elements less than or equal to pivot go to the left, greater go to the right
        for (int j = low; j < high; j++) { // o(n)
            if (array[j].compareTo(pivot) <= 0) { // o(1)
                i++; // o(1)
                T temp = array[i]; // o(1)
                array[i] = array[j]; // o(1)
                array[j] = temp; // o(1)
            }
        }
        // Placing the pivot element at the correct position
        // All elements to the left are less than or equal to pivot, and all to the right are greater
        T temp = array[i + 1]; // o(1)
        array[i + 1] = array[high]; // o(1)
        array[high] = temp; // o(1)

        return i + 1; // o(1)
    }

    // Binary Search
    public int binarySearch(T[] array, T target, Comparator<T> comparator) { // o(log n)
        if (array == null || array.length == 0 || target == null) // o(1)
            return -1; // o(1)
        // The array should be sorted based on the comparator provided using Arrays.sort(array, comparator)
        int left = 0, right = array.length - 1; // o(1)
        while (left <= right) { // o(log n)
            int mid = left + (right - left) / 2; // o(1)
            int cmp = comparator.compare(array[mid], target); // o(1)
            if (cmp == 0) // o(1)
                return mid; // o(1)
            if (cmp < 0) // o(1)
                left = mid + 1; // o(1)
            else
                right = mid - 1; // o(1)
        }
        return -1; // o(1)
    }
}