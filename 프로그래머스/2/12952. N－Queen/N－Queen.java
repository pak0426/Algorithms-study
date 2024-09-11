import java.util.*;

class Solution {
    
    private static int[][] board;
    private static int N, count;
    
    public int solution(int n) {
        board = new int[n][n];
        N = n;
        count = 0;
        
        backtrack(0);
        
        return count;
    }
    
    private static void backtrack(int row) {
        if (row == N) {
            count++;
            return;
        }
        
        
        for (int col = 0; col < N; col++) {
            if(isValid(row, col)) {
                board[row][col] = 1;
                backtrack(row + 1);
                board[row][col] = 0;
            }
        }
    }
    
    
    private static boolean isValid(int row, int col) {
        // 같은 열에 다른 퀸이 없는지
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        
        // 왼쪽 위 대각선 체크
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) return false;
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < N) {
            if (board[i][j] == 1) return false;
            i--;
            j++;
        }
        
        return true;
    }
    
    
}