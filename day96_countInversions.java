class Solution {
    public int day96_countInversions(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right);

        count += merge(arr, left, mid, right);
        return count;
    }

    private int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All remaining elements in left half form inversions
                count += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
        return count;
    }

    // Example run
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Number of inversions: " + sol.day96_countInversions(arr));
        // Output: 3 (pairs: (2,1), (4,1), (4,3))
    }
}
