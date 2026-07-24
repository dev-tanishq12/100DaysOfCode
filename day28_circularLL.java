import java.util.Scanner;

public class day28_circularLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node createCircularLL(int n, Scanner sc) {
        if (n == 0) {
            return null;
        }

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Last node points back to head
        tail.next = head;

        return head;
    }

    static void display(Node head) {
        if (head == null) {
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data);
            temp = temp.next;

            if (temp != head) {
                System.out.print(" ");
            }
        } while (temp != head);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the circular linked list: ");
        int n = sc.nextInt();

        System.out.print("Enter the elements: ");
        Node head = createCircularLL(n, sc);

        display(head);

        sc.close();
    }
}