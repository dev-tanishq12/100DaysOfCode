import java.util.*;
public class day32_pushPop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements to push: ");
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        // Push elements
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.print("Enter number of elements to pop: ");
        int m = sc.nextInt();

        // Pop elements
        for (int i = 0; i < m; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                System.out.println("Stack Underflow");
            }
        }
        // Print remaining stack
        while (!stack.isEmpty()) {
        System.out.print(stack.pop() + " ");
}

        sc.close();
    }
}
