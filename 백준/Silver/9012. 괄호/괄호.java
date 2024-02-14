import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line; i++) {
            String input = sc.next();
            Stack<String> stack = new Stack<>();

            try {
                for (int j = 0; j < input.length(); j++) {
                    char c = input.charAt(j);
                    if (c == '(') {
                        stack.push(String.valueOf("("));
                    }
                    else if (c == ')') {
                        stack.pop();
                    }
                }
                if (stack.isEmpty()) {
                    sb.append("YES\n");
                }
                else {
                    sb.append("NO\n");
                }
            }
            catch (EmptyStackException e) {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}