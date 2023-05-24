class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i < quiz.length; i++) {
            
            int front = 0;
            int back = 0;
            String mid = "";
            int last = 0;
            
            
                
            front = Integer.parseInt(quiz[i].split(" ")[0]);
            mid = quiz[i].split(" ")[1];
            back = Integer.parseInt(quiz[i].split(" ")[2]);
            last = Integer.parseInt(quiz[i].split(" ")[4]);
            
            
            int imsi = 0;
            if(mid.equals("+")) {
                imsi = front + back;
            }
            else {
                imsi = front - back;
            }
            
            if(imsi == last) {
                answer[i] = "O";
            }
            else {
                answer[i] = "X";
            }
        }
        
        return answer;
    }
}