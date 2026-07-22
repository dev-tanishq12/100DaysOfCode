import java.util.Scanner;
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class day26_doublyLinkedlist {

    static Node head = null;
    static Node tail = null;

    // Insert node at the end
    static void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Traverse and print the list
    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the doubly linked list: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            insert(sc.nextInt());
        }

        display();

        sc.close();
    }
}