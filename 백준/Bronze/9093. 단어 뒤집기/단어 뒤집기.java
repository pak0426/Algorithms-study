import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());

        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < line; i++) {
            String str = br.readLine();
            String arr[] = str.split(" ");

            for (int j = 0; j < arr.length; j++) {
                String s = arr[j];

                StringBuilder sb = new StringBuilder();
                sb.append(s);
                SB.append(sb.reverse() + " ");
            }
            SB.append("\n");
        }
        System.out.println(SB);
    }
}