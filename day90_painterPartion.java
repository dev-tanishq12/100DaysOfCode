import java.util.*;

public class day90_painterPartion {
    public static boolean isPossible(int[] boards, int n, int k, int limit) {
        int painters = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (boards[i] > limit) return false; // single board exceeds limit

            if (sum + boards[i] > limit) {
                painters++;
                sum = boards[i];
                if (painters > k) return false;
            } else {
                sum += boards[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] boards = new int[n];
        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();
        }

        int low = Arrays.stream(boards).max().getAsInt();
        int high = Arrays.stream(boards).sum();
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(boards, n, k, mid)) {
                result = mid;
                high = mid - 1; // try smaller maximum
            } else {
                low = mid + 1; // increase limit
            }
        }

        System.out.println(result);
        sc.close();
    }
}
