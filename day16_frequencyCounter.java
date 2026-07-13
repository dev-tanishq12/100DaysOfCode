import java.util.*;
public class day16_frequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }

        sc.close();
    }

}
