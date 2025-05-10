import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CompareSorts {

    public static void main(String[] args) {
        // Input sizes for testing
        int[] sizes = {100, 1000, 5000, 10000, 20000, 50000};

        // Create a file to write the results
        try (FileWriter writer = new FileWriter("sorting_times.txt")) {
            writer.write("Size\tQuickSort (ms)\tRandomized QuickSort (ms)\n");

            for (int size : sizes) {
                // Generate a random array for each size
                int[] arr = generateRandomArray(size);

                // Measure time for QuickSort
                long quickSortTime = measureTimeQuickSort(arr);

                // Measure time for Randomized QuickSort
                long randomizedQuickSortTime = measureTimeRandomizedQuickSort(arr);

                // Write the results to the file
                writer.write(size + "\t" + quickSortTime + "\t" + randomizedQuickSortTime + "\n");
            }

            System.out.println("Results saved to sorting_times.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
        }
    }

    // Method to generate random array of given size
    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);  // Random numbers between 0 and 999
        }
        return arr;
    }

    // Measure time for QuickSort
    private static long measureTimeQuickSort(int[] arr) {
        long start = System.nanoTime();
        QuickSort.quickSort(arr.clone(), 0, arr.length - 1); // Make a clone to keep original array intact
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // Convert to milliseconds
    }

    // Measure time for Randomized QuickSort
    private static long measureTimeRandomizedQuickSort(int[] arr) {
        long start = System.nanoTime();
        RandomizedQuickSort.randomizedQuickSort(arr.clone(), 0, arr.length - 1); // Make a clone to keep original array intact
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // Convert to milliseconds
    }
}

class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);  // Recursively sort left part
            quickSort(arr, pivotIndex + 1, high); // Recursively sort right part
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choosing the last element as pivot
        int i = low - 1;  // Pointer for the smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);  // Swap elements if they are smaller than pivot
            }
        }
        swap(arr, i + 1, high);  // Move pivot to correct position
        return i + 1;  // Return pivot index
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class RandomizedQuickSort {
    static Random rand = new Random();

    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex + 1, high);
        }
    }

    static int randomizedPartition(int[] arr, int low, int high) {
        int pivotIndex = rand.nextInt(high - low + 1) + low;  // Select a random pivot index
        swap(arr, pivotIndex, high);  // Swap the pivot element with the last element
        return partition(arr, low, high);  // Partition the array around the pivot
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivot is now the last element
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);  // Swap if element is smaller than pivot
            }
        }
        swap(arr, i + 1, high);  // Swap the pivot to its correct position
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
