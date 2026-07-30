import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Stack {
    Node top;

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (top == null) {
            return 0;
        }

        int value = top.data;
        top = top.next;
        return value;
    }
}

public class day34_postfixExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String exp = sc.nextLine();
        String[] arr = exp.split(" ");

        Stack stack = new Stack();

        for (int i = 0; i < arr.length; i++) {
            String ch = arr[i];

            if (ch.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            }
            else if (ch.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            }
            else if (ch.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            }
            else if (ch.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }
            else {
                stack.push(Integer.parseInt(ch));
            }
        }

        System.out.println(stack.pop());

        sc.close();
    }
}