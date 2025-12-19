package Assignment_1;
import java.util.Scanner;

public class MatrixOperations {

    // Method to read matrix
    static void readMatrix(int[][] mat, int r, int c, Scanner sc) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    // Method to display matrix
    static void printMatrix(int[][] mat, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Addition
    static void addMatrix(int[][] a, int[][] b, int r, int c) {
        int[][] sum = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        System.out.println("Addition Result:");
        printMatrix(sum, r, c);
    }

    // Subtraction
    static void subtractMatrix(int[][] a, int[][] b, int r, int c) {
        int[][] diff = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                diff[i][j] = a[i][j] - b[i][j];
            }
        }
        System.out.println("Subtraction Result:");
        printMatrix(diff, r, c);
    }

    // Multiplication
    static void multiplyMatrix(int[][] a, int[][] b, int r1, int c1, int c2) {
        int[][] mul = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    mul[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.out.println("Multiplication Result:");
        printMatrix(mul, r1, c2);
    }

    // Transpose
    static void transposeMatrix(int[][] a, int r, int c) {
        System.out.println("Transpose Matrix:");
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check Square Matrix
    static boolean isSquareMatrix(int r, int c) {
        return r == c;
    }

    // Check Diagonal Matrix
    static boolean isDiagonalMatrix(int[][] a, int r, int c) {
        if (r != c) return false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i != j && a[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    // Check Identity Matrix
    static boolean isIdentityMatrix(int[][] a, int r, int c) {
        if (r != c) return false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j && a[i][j] != 1)
                    return false;
                if (i != j && a[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of matrix: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] A = new int[r][c];
        int[][] B = new int[r][c];

        System.out.println("Enter elements of Matrix A:");
        readMatrix(A, r, c, sc);

        System.out.println("Enter elements of Matrix B:");
        readMatrix(B, r, c, sc);

        addMatrix(A, B, r, c);
        subtractMatrix(A, B, r, c);

        if (isSquareMatrix(r, c)) {
            multiplyMatrix(A, B, r, c, c);
            transposeMatrix(A, r, c);

            System.out.println("Matrix A is Square Matrix");

            if (isDiagonalMatrix(A, r, c))
                System.out.println("Matrix A is Diagonal Matrix");
            else
                System.out.println("Matrix A is NOT Diagonal Matrix");

            if (isIdentityMatrix(A, r, c))
                System.out.println("Matrix A is Identity Matrix");
            else
                System.out.println("Matrix A is NOT Identity Matrix");

        } else {
            System.out.println("Matrix is NOT a Square Matrix");
        }

        sc.close();
    }
}
