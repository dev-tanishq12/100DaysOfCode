import java.util.*;
public class day22_countNodes {
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

        // Count the number of nodes in the linked list
        int count = 0;
        Node temp = list.head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Number of nodes: " + count);

        sc.close();
    }
}
