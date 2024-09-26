import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        
        if (!s.contains("},{")) {
            return new int[]{Integer.parseInt(s)};
        }
        
        String arr[] = s.split("\\},\\{");
        
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            
            
            if (str.contains(",")) {
                String[] target = str.split(",");
                for (int j = 0; j < target.length; j++) {
                    set.add(target[j]);
                }
            }
            else {
                set.add(str);
            }
        }
        
        int[] answer = new int[set.size()];

        int index = 0;
        for (String a : set) {
            answer[index++] = Integer.parseInt(a);
        }
        
        return answer;
    }
}