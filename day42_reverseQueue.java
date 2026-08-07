import java.util.*;
import java.util.Stack;

public class day42_reverseQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }

        // Move queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Move stack back to queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        System.out.print("Reversed Queue: ");

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

        sc.close();
    }
}