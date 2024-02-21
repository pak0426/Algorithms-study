import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        final int LINE = Integer.parseInt(br.readLine());
        for (int i = 0; i < LINE; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            String command = arr[0];
            switch (command) {
                case "push":
                    String num = arr[1];
                    queue.offer(String.valueOf(num));
                    break;
                case "pop":
                    String poll = queue.poll();

                    if (poll == null) {
                        sb.append("-1\n");
                    }
                    else {
                        sb.append(poll + "\n");
                    }

                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    int size = queue.size();
                    if (size == 0) {
                        sb.append("1\n");
                    }
                    else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    String peek = queue.peek();
                    if (peek == null) {
                        sb.append("-1\n");
                    }
                    else {
                        sb.append(peek + "\n");
                    }
                    break;
                case "back":
                    LinkedList<String> list = (LinkedList<String>) queue;

                    if (queue.size() == 0) {
                        sb.append(-1 + "\n");
                    }
                    else {
                        sb.append(list.getLast() + "\n");
                    }
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
