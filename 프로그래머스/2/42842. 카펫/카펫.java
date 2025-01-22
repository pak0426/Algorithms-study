import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        // 넓이는 갈색 + 노랑 타일 수
        int totalSize = brown + yellow;
        
        // 세로의 최대 길이는 넓이의 제곱근
        int sqrt = (int) Math.sqrt(totalSize);
        
        // 세로의 최소는 3이어야 하므로 3부터 반복문 시작
        for (int h = 3; h <= sqrt; h++) {
            // 세로로 나눠떨어지면 가로의 길이가 나옴
            if (totalSize % h == 0) {
                int w = (int) (totalSize / h);
                
                // 갈색 타일의 개수가 일치한다면 카펫 완성
                if (brown == (w + h - 2) * 2) {
                    return new int[]{w, h};
                }
            }
        }
        
        
        return new int[]{};
    }
}