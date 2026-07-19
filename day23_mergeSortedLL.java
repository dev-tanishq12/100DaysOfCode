import java.util.*;
public class day23_mergeSortedLL {
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
    // Function to merge two sorted linked lists
    static Node mergeLists(Node l1, Node l2) {
    Node dummy = new Node(0);
    Node tail = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next;
        }
        tail = tail.next;
    }

    if (l1 != null)
        tail.next = l1;
    else
        tail.next = l2;

    return dummy.next;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list1 = new LinkedList();

        System.out.print("Enter number of elements to insert in first list: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list1.insert(val);
        }

        LinkedList list2 = new LinkedList();
        System.out.print("Enter number of elements to insert in second list: ");
        int m = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < m; i++) {
            int val = sc.nextInt();
            list2.insert(val);
        }

        Node mergedList = mergeLists(list1.head, list2.head);
        System.out.println("Merged Sorted List:");
        list1.display(mergedList);

        sc.close();
    }
}
