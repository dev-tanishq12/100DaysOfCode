import java.util.*;

public class day31_stackArray {

    static int[] stack;
    static int top = -1;

    // Push operation
    static void push(int value) {
        stack[++top] = value;
    }

    // Pop operation
    static void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top]);
            top--;
        }
    }

    // Display operation
    static void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of operations: ");
        int n = sc.nextInt();

        // At most n push operations can occur
        stack = new int[n];
        
        for (int i = 0; i < n; i++) {
            int operation = sc.nextInt();

            if (operation == 1) {
                int value = sc.nextInt();
                push(value);

            } else if (operation == 2) {
                pop();

            } else if (operation == 3) {
                display();
            }
        }

        sc.close();
    }
}