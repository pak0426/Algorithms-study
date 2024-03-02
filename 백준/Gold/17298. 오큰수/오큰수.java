import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String input = br.readLine();
        int[] arr = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                Integer pop = stack.pop();
                arr[pop] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int item : arr) {
            sb.append(item).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}