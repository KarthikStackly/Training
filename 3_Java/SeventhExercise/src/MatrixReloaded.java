import java.util.Arrays;
import java.util.Scanner;

public class MatrixReloaded {
    static void main() {
        Scanner scan = new Scanner(System.in);

        int dim = 3;
        int[][] matrix1 = new int[dim][dim];

        System.out.println("Enter the first matrix...");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.printf("[%d,%d] : ", i, j);
                matrix1[i][j] = scan.nextInt();
            }
        }

//        System.out.println("Your 1st Matrix : " + Arrays.deepToString(matrix1));
        System.out.println("\nYour first matrix is...");
        for (int[] eachRow : matrix1) {
//            for (int eachElement : eachRow) {
//                System.out.println(eachElement + " ");
//                System.out.printf("%d %n", eachElement);
                System.out.println(Arrays.toString(eachRow));
//            }
        }

        scan.nextLine();

        int[][] matrix2 = new int[3][3];
        System.out.println("\nEnter the second matrix...");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.printf("[%d,%d] : ", i, j);
                matrix2[i][j] = scan.nextInt();
            }
        }
        System.out.println("\nYour second matrix is...");
        for (int[] eachRow : matrix2) {
//            for (int eachElement : eachRow) {
//                System.out.println(eachElement + " ");
//                System.out.printf("%d %n", eachElement);
                System.out.println(Arrays.toString(eachRow));
//            }
//        }
}

        int[][] additionMatrix = new int[dim][dim];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                additionMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("\nYour Final matrix is...");
        for (int[] eachRow : additionMatrix) {
//            for (int eachElement : eachRow) {
//                System.out.println(eachElement + " ");
                System.out.println(Arrays.toString(eachRow));
//            }
        }

        scan.close();
    }
}
