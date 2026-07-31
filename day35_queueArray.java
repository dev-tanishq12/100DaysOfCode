import java.util.Scanner;

public class day35_queueArray {

    static int[] queue;
    static int front = 0;
    static int rear = -1;

    static void enqueue(int value) {
        rear++;
        queue[rear] = value;
    }

    static void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the queue: ");
        int n = sc.nextInt();

        queue = new int[n];
        System.out.println("Enter the elements of the queue: ");
        for (int i = 0; i < n; i++) {
            enqueue(sc.nextInt());
        }

        display();

        sc.close();
    }
}