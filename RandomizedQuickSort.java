import java.util.Random;

public class RandomizedQuickSort {
    
    static Random rand = new Random();

    // Randomized QuickSort logic
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex + 1, high);
        }
    }

    // Randomized partition logic (choosing a random pivot)
    private static int randomizedPartition(int[] arr, int low, int high) {
        int pivotIndex = rand.nextInt(high - low + 1) + low; // Random index
        swap(arr, pivotIndex, high);  // Swap the random pivot with the last element
        return partition(arr, low, high); // Standard partition function
    }

    // Partition method (like the one in QuickSort)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Measure time for the randomized quicksort
    public static long measureTime(int[] arr) {
        int[] copy = arr.clone();  // Work on a copy to avoid modifying original
        long start = System.nanoTime();
        randomizedQuickSort(copy, 0, copy.length - 1); // Sort the cloned array
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // Return time in milliseconds
    }

    // Optional: method to print the array (useful for testing)
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
