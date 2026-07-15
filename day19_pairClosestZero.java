import java.util.*;
public class day19_pairClosestZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        System.out.println("Enter elements of array: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){ 
            arr[i] = sc.nextInt();
        }

        // Step 1: Sort the array
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        int minSum = Integer.MAX_VALUE;
        int first = 0, second = 0;
        // Step 2: Two Pointer
        while (left < right) {

            int sum = arr[left] + arr[right];

            // Update answer if current sum is closer to zero
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                first = arr[left];
                second = arr[right];
            }

            // Move pointers
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                // Exact zero is the closest possible
                break;
            }
        }

        System.out.println(first + " " + second);

        sc.close();
    }
}
