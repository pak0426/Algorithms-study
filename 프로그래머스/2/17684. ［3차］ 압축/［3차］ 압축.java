/*
문제파악
- 메시지를 메시지를 압축하여 전송 효율을 높이는 업무
- 압축 전 정보를 완벽 복원 가능 무손실 압축 알고리즘 구현

*/

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> save = new HashMap<>();
        
        for (char c = 'A'; c <= 'Z'; c++) {
            int index = c - 'A' + 1;
            save.put(String.valueOf(c), index);
        }
        
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while (idx < msg.length()) {
            String str = "";
            
            while (idx < msg.length()) {
                char c = msg.charAt(idx);
                if (!save.containsKey(str + c)) {
                    break;
                }
                else {
                    str += c;
                    idx++;
                }
            }
            
            list.add(save.get(str));
            
            if (idx < msg.length()) {
                save.put(str + msg.charAt(idx), save.size() + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}