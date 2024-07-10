import java.util.*;

// 문제 분석
// 행과 열의 길이는 100이하 = 시간 복잡도를 신경쓰지 않아도 된다.
// 곱할 수 있는 배열만 주어진다 == 예외 처리를 신경쓰지 않아도 된다.
// 행렬의 곱은? 요소들을 곱한거에 대한 더하기임
// ex) [[1,4]] [[3,3]] = (1 * 3) + (4 * 3) = 15
// arr1[0][0] * arr2[0][0] + arr[0][1] * arr2[0][1]
// arr1[1][0] * arr2[0][0]
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {        
        // 행과 열을 정의
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        // 정답 배열 초기화
        int[][] answer = new int[r1][c2];
        
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