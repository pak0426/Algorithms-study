import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String words = sc.nextLine().toLowerCase();

        List<String> list = new ArrayList<>();
        for (int i=0; i < words.length(); i++) {
            String character = String.valueOf(words.charAt(i));
            list.add(character);
        }
        List<String> newList = list.stream().distinct().collect(Collectors.toList());
//        System.out.println("list = " + list);
//        System.out.println("newList = " + newList);

        List<Integer> numList = new ArrayList<>();
        for (int i=0; i < newList.size(); i++) {
            int frequency = Collections.frequency(list, newList.get(i));
            numList.add(frequency);
        }
//        System.out.println("numList = " + numList);

        int max = Collections.max(numList);
        int dupCnt = Collections.frequency(numList, max);
//        System.out.println("max = " + max);
//        System.out.println("dupCnt = " + dupCnt);

        if (dupCnt > 1) {
            System.out.println("?");
        }
        else {
            for (int i=0; i < numList.size(); i++) {
                if (numList.get(i) == max) {
                    System.out.println(newList.get(i).toUpperCase());
                }
            }
        }
    }
}