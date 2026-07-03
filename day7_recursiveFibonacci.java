import java.util.Scanner;
public class day7_recursiveFibonacci{
// But this recursive approach has O(2^n)
// optimal solution is dynamic approach
    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            System.out.print(fibonacci(i) + " ");
        }
        sc.close();
    }
}


/* This is Optimized Recursive with O(n)
import java.util.Scanner;

public class fibonacciDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        
        if (n <= 0) return;

        int[] fib = new int[n];
        fib[0] = 0;
        
        if (n > 1) {
            fib[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println("Fibonacci Series:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + " ");
        }
        sc.close();
    }
}
 */