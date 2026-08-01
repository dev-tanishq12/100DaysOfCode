import java.util.Scanner;

public class day36_circularQueue {

    static int[] queue;
    static int front = 0;
    static int rear = -1;
    static int size = 0;

    static void enqueue(int value) {
        if (size == queue.length) {
            System.out.println("Queue Full");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    static void dequeue() {
        if (size == 0) {
            System.out.println("Queue Empty");
            return;
        }

        front = (front + 1) % queue.length;
        size--;
    }

    static void display() {
        if (size == 0) {
            System.out.println("Queue Empty");
            return;
        }

        int i = front;

        for (int count = 0; count < size; count++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % queue.length;
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
        System.out.print("Enter the number of elements to dequeue: ");
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            dequeue();
        }

        display();

        sc.close();
    }
}