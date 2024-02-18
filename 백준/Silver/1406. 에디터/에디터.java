import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int line = Integer.parseInt(br.readLine());

        Stack<String> LStack = new Stack<>();
        Stack<String> RStack = new Stack<>();

        String[] arr = str.split("");
        for (String s : arr) {
            LStack.push(s);
        }

        for (int i = 0; i < line; i++) {
            String input = br.readLine();
            switch (input.charAt(0)) {
                case 'L': {
                    if (!LStack.isEmpty()) {
                        RStack.push(LStack.pop());
                    }
                    break;
                }
                case 'D': {
                    if (!RStack.isEmpty()) {
                        LStack.push(RStack.pop());
                    }
                    break;
                }
                case 'B': {
                    if (!LStack.isEmpty()) {
                        LStack.pop();
                    }
                    break;
                }
                case 'P': {
                    char c = input.charAt(2);
                    LStack.push(String.valueOf(c));
                    break;
                }
            }
        }

        while (!LStack.isEmpty()) {
            RStack.push(LStack.pop());
        }

        while (!RStack.isEmpty()) {
            bw.write(RStack.pop());
        }

        bw.flush();
        bw.close();
    }
}
