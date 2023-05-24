class Solution {
    public int solution(int num, int time) {
        int answer = 0;
        
        for(int i=1; i <= time; i++) {
            if(i == 1) {
                answer = num * 2;
            }
            else {
                answer = answer * 2;
            }
            
            System.out.println("answer : " + answer);
        }
        
        return answer;
    }
}