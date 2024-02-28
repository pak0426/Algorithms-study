import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            if (c == '(') {
                if (str.charAt(i + 1) == ')') {
                    result += stack.size();
                }
                stack.push(c);
            }
            else {
                if (str.charAt(i - 1) == ')') {
                    result += 1;
                }
                stack.pop();
            }
        }
        System.out.println(result);
    }
}
