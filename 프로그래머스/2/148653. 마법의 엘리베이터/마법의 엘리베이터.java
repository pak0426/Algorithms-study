class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10;
            int nextDigit = (storey / 10) % 10;
            
            if (digit > 5 || (digit == 5 && nextDigit >= 5)) {
                // 올림이 유리한 경우
                answer += (10 - digit);
                storey += 10;
            } else {
                // 내림이 유리한 경우
                answer += digit;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}