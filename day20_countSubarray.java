import java.util.*;

public class day20_countSubarray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 occurs once initially
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {

            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println("Count = " + count);

        sc.close();
    }
}