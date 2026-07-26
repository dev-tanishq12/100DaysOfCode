import java.util.Scanner;

public class day30_polynomialLL {

    static class Node {
        int coefficient;
        int exponent;
        Node next;

        Node(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }

    static void printPolynomial(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.coefficient);

            if (temp.exponent > 0) {
                System.out.print("x");

                if (temp.exponent > 1) {
                    System.out.print("^" + temp.exponent);
                }
            }

            if (temp.next != null) {
                System.out.print(" + ");
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms in the polynomial: ");
        int n = sc.nextInt();

        Node head = null;
        Node tail = null;
        System.out.println("Enter the coefficients and exponents of the polynomial terms:");
        for (int i = 0; i < n; i++) {
            int coefficient = sc.nextInt();
            int exponent = sc.nextInt();

            Node newNode = new Node(coefficient, exponent);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        printPolynomial(head);

        sc.close();
    }
}