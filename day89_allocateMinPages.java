import java.util.*;

public class day89_allocateMinPages {
    public static boolean isFeasible(int[] arr, int n, int m, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < n; i++) {
            if (pageSum + arr[i] > mid) {
                studentCount++;
                pageSum = arr[i];
                if (studentCount > m) return false;
            } else {
                pageSum += arr[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int num : arr) sum += num;

        int left = Arrays.stream(arr).max().getAsInt(); // max pages in a single book
        int right = sum; // total pages

        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isFeasible(arr, n, m, mid)) {
                result = mid; // feasible, try for a smaller maximum
                right = mid - 1;
            } else {
                left = mid + 1; // not feasible, increase the maximum
            }
        }

        System.out.println(result);
        sc.close();
    }
}