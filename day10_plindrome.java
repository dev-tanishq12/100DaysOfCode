import java.util.Scanner;
public class day10_plindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string: ");
        String str = sc.nextLine();
        char[] arr = str.toCharArray();

        int s = 0;
        int e = arr.length - 1;
        while(s <= e){
            if(arr[s] == arr[e]){
                System.out.println("YES");
                return;
            }
            s++;
            e--;
        }
        System.out.println("NO");

        sc.close();
    }
}