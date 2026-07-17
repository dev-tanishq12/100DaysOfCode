import java.util.*;
public class day21_singlyLinkedList {
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

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();

        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.insert(val);
        }
        list.display();

        sc.close();
    }
}