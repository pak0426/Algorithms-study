/*
문제 파악
- 1부터 n까지 붙어있는 n명의 사람이 영어 끝말잇기를 한다.

- 사람의 수 n, 말한 단어 배열 words
- 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에서 탈락하는지를 구해서 return
*/

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            
            String word = words[i];
            if (i > 0) {
                String bfWord = words[i - 1];
                
                if (set.contains(words[i]) || !word.startsWith(bfWord.substring(bfWord.length() - 1))) {
                    return new int[]{i % n + 1, i / n + 1};
                }
            }
            set.add(words[i]);
        }

        return answer;
    }
}