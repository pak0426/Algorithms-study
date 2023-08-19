import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        sc.close();

        boolean isSame = false;
        for (int i=0; i < a.length(); i++) {
            char start = a.charAt(i);
            char end = a.charAt(a.length() - i - 1);

            if (start != end) {
                isSame = true;
                break;
            }
        }

        if (!isSame) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}
