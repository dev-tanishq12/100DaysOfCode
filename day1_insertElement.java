import java.util.Scanner;
class day1_insertElement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        System.out.println("Enter elements of array: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){ 
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the position at which element to be inserted: ");
        int pos = sc.nextInt();
        System.out.println("Enter the element to be inserted: ");
        int element = sc.nextInt();

        System.out.println("New updated array: ");
        for(int i=0; i<n; i++){
            if(i == pos-1){
                System.out.print(element + " ");
            }
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}