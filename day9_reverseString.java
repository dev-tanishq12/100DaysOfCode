import java.util.Scanner;
public class day9_reverseString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string in lower order: ");
        String str = sc.nextLine();
        char[] arr = str.toCharArray();

        int s = 0;
        int e = arr.length - 1;

        while(s <= e){
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;

            s++;
            e--;
        }
        System.out.println(new String(arr));

        sc.close();
    }
}
