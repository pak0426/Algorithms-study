import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            if (c == '<') {
                flag = true;

                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
            else if (c == '>') {
                flag = false;
                sb.append(c);
                continue;
            }

            if (flag) {
                sb.append(c);
                continue;
            }

            if (c == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
                continue;
            }

            stack.push(c);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}