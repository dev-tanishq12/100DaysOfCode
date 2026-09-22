import java.util.*;

public class day88_aggressiveCows {
    public static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1; // place first cow at first stall
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
                if (count == k) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] stalls = new int[n];

        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        Arrays.sort(stalls);

        int left = 1; // minimum possible distance
        int right = stalls[n - 1] - stalls[0]; // maximum possible distance
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid;   // feasible, try larger distance
                left = mid + 1;
            } else {
                right = mid - 1; // not feasible, try smaller distance
            }
        }

        System.out.println(result);
        sc.close();
    }
}
