import java.util.Scanner;
public class day5_arrangeArival_log {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of array1: ");
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter size of array2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of array2: ");
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] mergedArray = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        // Copy any remaining elements from either array
        while (i < n1) {
            mergedArray[k++] = arr1[i++];
        }
        while (j < n2) {
            mergedArray[k++] = arr2[j++];
        }

        // Print the merged array
        System.out.println("Merged array: ");
        for (int l = 0; l < mergedArray.length; l++) {
            System.out.print(mergedArray[l] + " ");
        }
        sc.close();
    }
}