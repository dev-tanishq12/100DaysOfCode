import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class day41_QueueLL {

    static Node front = null;
    static Node rear = null;

    // Enqueue
    static void enqueue(int value) {
        Node newNode = new Node(value);

        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue
    static void dequeue() {
        if (front == null) {
            System.out.println(-1);
            return;
        }

        System.out.println(front.data);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of operations: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String op = sc.next();

            if (op.equals("enqueue")) {
                int value = sc.nextInt();
                enqueue(value);
            } else if (op.equals("dequeue")) {
                dequeue();
            }
        }

        sc.close();
    }
}