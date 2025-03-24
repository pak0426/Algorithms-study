class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int[] answer = {0, sequence.length - 1};
        int minLength = sequence.length;
        
        while (right < sequence.length) {
            if (sum < k) {
                // k보다 작으면 right 포인터 이동
                right++;
                if (right < sequence.length) sum += sequence[right];
            }
            else if (sum > k) {
                // k보다 크면 left 포인터 이동
                sum -= sequence[left];
                left++;
            }
            else {
                int currentLength = right - left;
                
                if (currentLength < minLength) {
                    minLength = currentLength;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}