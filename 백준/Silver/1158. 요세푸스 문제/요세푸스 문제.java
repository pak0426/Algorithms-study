import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        String[] arr = str.split(" ");
        int size = Integer.parseInt(arr[0]);
        int index = Integer.parseInt(arr[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= size; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 1; i <= index; i++) {
                Integer poll = queue.poll();

                if (i == index) {
                    if (queue.size() == 0) {
                        sb.append(poll);
                    }else {
                        sb.append(poll + ", ");
                    }
                }
                else {
                    queue.add(poll);
                }
            }
        }
        sb.append(">");
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
