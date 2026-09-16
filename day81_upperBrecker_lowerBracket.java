import java.util.*;

public class day81_upperBrecker_lowerBracket {
    // Lower Bound: first index with value >= x
    public static int lowerBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Upper Bound: first index with value > x
    public static int upperBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements (sorted)
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target value
        int x = sc.nextInt();

        int lb = lowerBound(arr, x);
        int ub = upperBound(arr, x);

        System.out.println(lb + " " + ub);

        sc.close();
    }
}
