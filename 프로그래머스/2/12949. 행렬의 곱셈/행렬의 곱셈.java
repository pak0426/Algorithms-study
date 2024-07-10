import java.util.*;

// 문제 분석
// 행과 열의 길이는 100이하 = 시간 복잡도를 신경쓰지 않아도 된다.
// 곱할 수 있는 배열만 주어진다 == 예외 처리를 신경쓰지 않아도 된다.
// 행렬의 곱은? 요소들을 곱한거에 대한 더하기임
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        
        int r1 = arr1.length; // 3
        int c1 = arr1[0].length; // 2
        int r2 = arr2.length; // 2
        int c2 = arr2[0].length; // 2
        
        answer = new int[r1][c2];
        
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        
        return answer;
    }
}