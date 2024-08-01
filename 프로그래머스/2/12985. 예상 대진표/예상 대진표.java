/*
문제 파악
- 게임대회, N명 참가, 토너먼트
- 참가자는 각각 N번을 배정받는다
- 각 게임에서 이기면 다음 라운드 진출, 번호를 다시 1번부터 n/2 번을 차례대로 부여 받는다.
- 최종 1명이 남을때까지 진행

- A번, B번 참가자가 몇 라운드에 만나는지 return
*/
import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while (true) {
            answer++;
            a = solve(a);
            b = solve(b);
            if (a == b) {
                break;
            }
        }

        return answer;
    }
    
    public int solve(int num) {
        if (num == 0) {
            return 0;           
        }
        
        if (num % 2 == 0) {
            return num /= 2;
        }
        else {
            return num  = (num + 1) / 2;
        }
    }
    
}