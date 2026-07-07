import java.util.Scanner;
public class day11_matrixAddition {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the number of rows: ");
       int r = sc.nextInt();
       System.out.println("Enter number of columns: ");
       int c = sc.nextInt();

       int[][] matrix1 = new int[r][c];
       int [][] matrix2 = new int[r][c];
       int[][] result = new int[r][c];

       System.out.println("Enter elements for the First Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements for the Second Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("\nResultant Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println(); //move to the next row
        }

        sc.close();
    }
}
