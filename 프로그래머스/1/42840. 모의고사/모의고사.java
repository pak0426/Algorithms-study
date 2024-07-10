import java.util.*;

/*
 * 문제 파악.
 * 수포자는 3명, 수포자 찍는 패턴이 반복된다.
 * 정답은 가장 많은 문제를 맞힌 사람만 출력, 여럿일 경우는 결과 값(플레이어가 아님)을 오름차순으로 정렬만
 */
class Solution {
    public int[] solution(int[] answers) {
        // answers = 정답의 배열
        int[][] players = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[players.length];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < players.length; j++) {
                int index = i % players[j].length;
                if (answers[i] == players[j][index]) {
                    scores[j]++;
                }
            }
        }
        
        int max = Arrays.stream(scores).max().getAsInt();
        
        List<Integer> result = new ArrayList();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}