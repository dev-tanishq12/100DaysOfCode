import java.util.*;

public class day86_Sqrt_BinarySearch {
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right; // right is the integer part of the square root
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int x = sc.nextInt();
        int result = mySqrt(x);
        System.out.println("The integer part of the square root of " + x + " is: " + result);

        sc.close();
    }
}