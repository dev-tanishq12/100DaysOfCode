import java.util.Scanner;
public class day12_SymmetricMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        if (r != c) {
            System.out.println("Not Symmetric Matrix");
            sc.close();
            return;
        }

        int[][] matrix = new int[r][c];

        System.out.println("Enter array elements: ");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j] != matrix[j][i]){
                    System.out.println("Not Symmetric Matrix");
                    sc.close();
                    return;
                }
            }
        }
        System.out.println("Symmetric Matrix");
        sc.close();
    }
}
