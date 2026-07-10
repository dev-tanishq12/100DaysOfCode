import java.util.Scanner;
public class day14_IdentityMatrix {
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

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if((i==j && matrix[i][j]!=1) || (i!=j && matrix[i][j]!=0)){
                    System.out.println("Not an identity matrix.");
                    return;
                }
            }
        }

        System.out.println("Identity matrix.");
        sc.close();
    }
}