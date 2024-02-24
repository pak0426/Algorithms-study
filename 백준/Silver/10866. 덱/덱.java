import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(br.readLine());

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            str = arr[0];

            int size = deque.size();

            switch (str) {
                case "push_front":
                    deque.addFirst(arr[1]);
                    break;
                case "push_back":
                    deque.addLast(arr[1]);
                    break;
                case "pop_front":
                    String pollFirst = deque.pollFirst();
                    if (pollFirst == null) {
                        sb.append("-1\n");
                    }
                    else sb.append(pollFirst + "\n");
                    break;
                case "pop_back":
                    String pollLast = deque.pollLast();
                    if (pollLast == null) {
                        sb.append("-1\n");
                    }
                    else sb.append(pollLast + "\n");
                    break;
                case "size":
                    sb.append(size + "\n");
                    break;
                case "empty":
                    if (size == 0) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    String peekFirst = deque.peekFirst();
                    if (peekFirst == null) {
                        sb.append("-1\n");
                        break;
                    }
                    else sb.append(peekFirst + "\n");
                    break;
                case "back":
                    String peekLast = deque.peekLast();
                    if (peekLast == null) {
                        sb.append("-1\n");
                    }
                    else sb.append(peekLast + "\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
