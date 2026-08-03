import java.util.*;

public class day38_dequeueOperations {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        // push_front
        deque.addFirst(20);
        deque.addFirst(10);

        // push_back
        deque.addLast(30);
        deque.addLast(40);

        System.out.println("Deque: " + deque);

        // front
        System.out.println("Front: " + deque.peekFirst());

        // back
        System.out.println("Back: " + deque.peekLast());

        // size
        System.out.println("Size: " + deque.size());

        // empty
        System.out.println("Is Empty: " + deque.isEmpty());

        // pop_front
        System.out.println("Removed Front: " + deque.pollFirst());

        // pop_back
        System.out.println("Removed Back: " + deque.pollLast());

        System.out.println("Deque after deletion: " + deque);

        // reverse
        ArrayList<Integer> list = new ArrayList<>(deque);
        Collections.reverse(list);
        System.out.println("Reversed: " + list);

        // sort
        Collections.sort(list);
        System.out.println("Sorted: " + list);

        // clear
        deque.clear();
        System.out.println("Deque after clear: " + deque);

        System.out.println("Is Empty: " + deque.isEmpty());
    }
}