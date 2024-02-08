import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Integer> stack = new ArrayList<>();

    private static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);


        int line = sc.nextInt();

        for (int i = 0; i < line; i ++) {
            String str = sc.next();
            switch (str) {
                case "push":
                    push(sc.nextInt());
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    public static void push(int num) {
        stack.add(num);
    }

    public static void pop() {
        if (stack.size() == 0) {
            sb.append(-1 + "\n");
            return;
        }
        sb.append(stack.get(stack.size() - 1) + "\n");
        stack.remove(stack.size() - 1);
    }

    public static void size() {
        sb.append(stack.size() + "\n");
    }

    public static void empty() {
        if (stack.size() == 0) {
            sb.append(1 + "\n");
        }
        else {
            sb.append(0 + "\n");
        }
    }

    public static void top() {
        if (stack.size() == 0) {
            sb.append(-1 + "\n");
            return;
        }
        sb.append(stack.get(stack.size()- 1) + "\n");
    }
}
