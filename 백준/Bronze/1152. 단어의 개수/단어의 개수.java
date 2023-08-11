import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine().trim();
        sc.close();

        if (words.isEmpty()) System.out.println(0);
        else {
            String arr[] = words.split(" ");
            System.out.println(arr.length);
        }
    }
}