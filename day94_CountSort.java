import java.util.Arrays;

public class day94_CountSort {
    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        // Find min and max to handle negative numbers
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        // Count array and output array
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count frequencies
        for (int num : arr) {
            count[num - min]++;
        }

        // Cumulative counts
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build output (iterate backwards for stability)
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // Example run
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 2, 0, -1};
        countingSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
