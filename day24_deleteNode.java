import java.util.*;
public class day24_deleteNode {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head, tail;

        void insert(int val) {
            Node node = new Node(val);
            if (head == null)
                head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }

        void display(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Function to delete a node from the linked list
    static Node deleteNode(Node head, int key) {
        if (head == null)
            return null;

        if (head.val == key)
            return head.next;

        Node current = head;
        while (current.next != null && current.next.val != key) {
            current = current.next;
        }

        if (current.next != null)
            current.next = current.next.next;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the linked list: ");
        int n = sc.nextInt();
        System.out.print("Enter the elements: ");
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.insert(val);
        }

        System.out.print("Enter the value of the node to be deleted: ");
        int key = sc.nextInt();

        list.head = deleteNode(list.head, key);
        System.out.print("Linked list after deletion: ");
        list.display(list.head);

        sc.close();
    }
}