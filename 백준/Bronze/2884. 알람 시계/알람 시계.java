import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        int hour = in.nextInt();
        int min = in.nextInt();
        in.close();

        if (min < 45) {
            hour -= 1;
            min = 60 - 45 + min;

            if (hour == -1) hour = 23;
        }
        else {
            min = min - 45;
        }

        System.out.println(hour + " " + min);
    }
}