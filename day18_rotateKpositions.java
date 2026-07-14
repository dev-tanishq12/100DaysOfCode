import java.util.Scanner;

public class day18_rotateKpositions {
    public static void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        System.out.println("Enter elements of array: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){ 
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter number of positions to rotate: ");
        int k = sc.nextInt();
        k = k % n; // To handle cases where k is greater than n

        reverse(arr, 0, n - 1); // Reverse the entire array
        reverse(arr, 0, k - 1); // Reverse the first k elements
        reverse(arr, k, n - 1); // Reverse the remaining n-k elements
        
        System.out.println("Array after rotation: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}