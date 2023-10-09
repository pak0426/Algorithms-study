/*
       7
     10 15
    18 16 15 
   20 25 20 19
  24 30 27 26 24

채점 결과
정확성: 64.3
효율성: 35.7
합계: 100.0 / 100.0
*/

class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) { //왼쪽 끝
                    triangle[i][j] += triangle[i-1][j];
                }
                else if (j == i) { //오른쪽 끝
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else { //가운데에서 위쪽 두개 중 큰거를 선택
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }
        
        return answer;
    }
}
