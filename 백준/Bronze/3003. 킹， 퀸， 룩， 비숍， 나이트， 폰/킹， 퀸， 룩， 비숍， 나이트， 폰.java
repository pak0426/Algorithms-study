import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        int origin[] = {1, 1, 2, 2, 2, 8};

        for (int i=0; i < arr.length; i++) {
            int item = arr[i];
            int jtem = origin[i];
            int mius = jtem - item;

            if (i == arr.length-1) {
                System.out.print(mius);
            }
            else {
                System.out.print(mius + " ");
            }

        }
    }
}
