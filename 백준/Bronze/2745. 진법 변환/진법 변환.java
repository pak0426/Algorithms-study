import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();

        char[] arrCh = N.toCharArray();

        int result = 0;
        for (int i=0; i < arrCh.length; i++) {
            int j = arrCh.length - 1 - i;
            char c = arrCh[i];
            int num = Character.getNumericValue(c);
            result += Math.pow(B, j) * num;
        }
        System.out.println(result);
    }
}