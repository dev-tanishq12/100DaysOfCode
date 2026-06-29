import java.util.Scanner;

public class day3_linearSearch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        System.out.println("Enter elements of array: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){ 
            arr[i] = sc.nextInt();
        }
         
        System.out.println("Enter the element for searching: ");
        int target = sc.nextInt();

        int comparisons = 0;

        for(int i=0; i<n; i++){
            comparisons++;
            if(arr[i] == target){
                System.out.println("Element found at index: " + i);
                break;
            }
        }
        System.out.println("Comparisons = " + comparisons);
        sc.close();
    }
}