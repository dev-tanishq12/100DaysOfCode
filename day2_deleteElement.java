import java.util.Scanner;
public class day2_deleteElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        System.out.println("Enter elements of array: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){ 
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the position of element to be deleted: ");
        int pos = sc.nextInt();

        System.out.println("New updated array: ");
        for(int i=0; i<n; i++){
            if(i == pos){
                continue;
            }
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
