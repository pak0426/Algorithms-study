import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        in.close();

        int total = 0;
        if (a == b && b == c) {
            total = 10000 + a * 1000;
        }
        else if (a == b || b == c || a == c) {
            int same = 0;
            if (a == b) same = a;
            else if (b == c) same = b;
            else same = c;
            total = 1000 + same * 100;
        }
        else {
            int max = Math.max(a, Math.max(b, c));
            total = max * 100;
        }

        System.out.println(total);
    }
}
