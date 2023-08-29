import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int [][] arrA = new int[a][b];
        int [][] arrB = new int[a][b];

        for (int i=0; i < a; i++) {
            for (int j=0; j < b; j++) {
                arrA[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i < a; i++) {
            for (int j=0; j < b; j++) {
                arrB[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i < a; i++) {
            for (int j=0; j < b; j++) {
                System.out.print(arrA[i][j] + arrB[i][j] + " ");
            }
            System.out.println();
        }
    }
}