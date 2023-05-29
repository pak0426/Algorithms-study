class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.toLowerCase().split("");
        
        boolean isSpace = true;
        for (String word : arr) {
            answer += isSpace ? word.toUpperCase() : word;
            
            isSpace = word.equals(" ") ? true : false;
        }
        
        System.out.println("answer : " + answer);
        return answer;
    }
}