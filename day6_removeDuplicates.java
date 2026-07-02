import java.util.Scanner;
public class day6_removeDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        System.out.println("Enter elements of array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0;
        int j = 1;

        while (j < n) {

            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
            j++;
        }
        System.out.print("Array after removing duplicates: ");
        for (int k = 0; k <= i; k++) {
            System.out.print(arr[k] + " ");
        }
        sc.close();
    }
}