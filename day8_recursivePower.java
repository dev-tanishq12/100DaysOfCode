import java.util.*;
public class day8_recursivePower{

    static int power(int base, int exponent){
        if(exponent == 0){
            return 1;
        }
        return base * power(base, exponent - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int a = sc.nextInt();

        System.out.println("Enter the power: ");
        int b = sc.nextInt();
        
        System.out.println("Answer: " + power(a,b));

        sc.close();
    }
}