import java.util.Scanner;
public class day15_diagnoalsumMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows: ");
       int r = sc.nextInt();

       System.out.println("Enter columns: ");
       int c = sc.nextInt();

       int[][] matrix = new int[r][c];
       System.out.println("Enter the elements of the matrix:");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i==j){
                    sum = sum + matrix[i][j];
                }
            }
        }
        System.out.println("Sum of the diagonal = " + sum);

        sc.close();

        

    }
}
