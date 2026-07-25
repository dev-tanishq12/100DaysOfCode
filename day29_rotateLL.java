import java.util.Scanner;

public class day29_rotateLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node rotateRight(Node head, int n, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Handle k greater than n
        k = k % n;

        if (k == 0) {
            return head;
        }

        // Find the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Make the linked list circular
        last.next = head;

        // Move to the (n-k)th node
        Node newLast = head;
        for (int i = 1; i < n - k; i++) {
            newLast = newLast.next;
        }

        // New head is the next node
        Node newHead = newLast.next;

        // Break the circular linked list
        newLast.next = null;

        return newHead;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" ");
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        Node head = null;
        Node tail = null;
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter the number of positions to rotate: ");
        int k = sc.nextInt();

        head = rotateRight(head, n, k);

        printList(head);

        sc.close();
    }
}