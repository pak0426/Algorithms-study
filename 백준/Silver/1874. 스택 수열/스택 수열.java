import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int line = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int index = 0;
        boolean isError = false;
        for (int i = 0; i < line; i++) {
            int input = sc.nextInt();

            for (int j = index; j < input; j++) {
                index++;
                stack.push(index);
                sb.append("+\n");
            }

            if (stack.peek() == input) {
                sb2.append(stack.pop());
                sb.append("-\n");
            }
            else {
                System.out.println("NO");
                isError = !isError;
                break;
            }
        }

        if (!isError) {
            System.out.println(sb);
        }
    }
}