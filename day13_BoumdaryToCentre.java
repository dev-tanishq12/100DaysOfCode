import java.util.Scanner;
public class day13_BoumdaryToCentre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        System.out.println("Enter the elements of the matrix:");
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int startingRow = 0;
        int endingRow = r - 1;
        int startingCol = 0;
        int endingCol = c - 1;
        while(startingRow <= endingRow && startingCol <= endingCol){
            for(int i=startingCol; i<=endingCol; i++){
                System.out.print(matrix[startingRow][i] + " ");
            }
            startingRow++;
            for(int i=startingRow; i<=endingRow; i++){
                System.out.print(matrix[i][endingCol] + " ");
            }
            endingCol--;
            if(startingRow <= endingRow){
                for(int i=endingCol; i>=startingCol; i--){
                    System.out.print(matrix[endingRow][i] + " ");
                }
                endingRow--;
            }
            if(startingCol <= endingCol){
                for(int i=endingRow; i>=startingRow; i--){
                    System.out.print(matrix[i][startingCol] + " ");
                }
                startingCol++;
            }
        }
        sc.close();
    }
}
