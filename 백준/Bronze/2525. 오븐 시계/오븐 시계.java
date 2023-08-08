import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int hour = in.nextInt();
        int min = in.nextInt();
        int addMin = in.nextInt();
        in.close();

        if (min + addMin >= 60) {
            int tmpHour = (min + addMin) / 60;
            int tmpMin =  (min + addMin) % 60;

            hour += tmpHour;
            min = tmpMin;

            if (hour > 23) {
                hour = hour % 24;
            }
        }
        else {
            min += addMin;
        }

        System.out.println(hour + " " + min);
    }
}
