import java.util.*;

class Solution {
    /*
     * numbers의 길이가 100이하이므로 시간 복잡도를 고려하지 않아도 된다.
     */ 
    public int[] solution(int[] numbers) {
        int[] answer = {};
        // 중복이 없는 컬렉션 Set을 이용
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}