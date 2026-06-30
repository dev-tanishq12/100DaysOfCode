import java.util.Scanner;
//Using two Pointer Approach
public class day4_reversearray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        System.out.println("Enter elements of array: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){ 
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        System.out.println("Reversed array:");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
