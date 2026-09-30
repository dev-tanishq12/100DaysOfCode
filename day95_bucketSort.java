import java.util.*;

class day95_bucketSort {
    public static void bucketSort(double[] nums) {
        int n = nums.length;
        if (n <= 0) return;

        // Step 1: Create n empty buckets
        List<List<Double>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Step 2: Distribute numbers into buckets
        for (double num : nums) {
            int idx = (int)(n * num); // bucket index
            buckets.get(idx).add(num);
        }

        // Step 3: Sort each bucket
        for (List<Double> bucket : buckets) {
            Collections.sort(bucket); // insertion sort can also be used
        }

        // Step 4: Concatenate buckets
        int index = 0;
        for (List<Double> bucket : buckets) {
            for (double num : bucket) {
                nums[index++] = num;
            }
        }
    }

    // Example run
    public static void main(String[] args) {
        double[] nums = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
        bucketSort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));
    }
}
