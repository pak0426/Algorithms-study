class Solution {
    private static int[] apeach;
    private static int N;
    private static int[] result;
    private static int maxDiff;
    
    public int[] solution(int n, int[] info) {
        int N = n;
        apeach = info;
        result = new int[11];
        maxDiff = 0;
        
        backtrack(new int[11], 0, n);
        
        return maxDiff > 0 ? result : new int[]{-1};
    }
    
    private static void backtrack(int[] ryan, int index, int remainArrows) {
        if (index == 11 || remainArrows == 0) {
            if (remainArrows > 0) {
                ryan[10] += remainArrows;
            }
            calculateScore(ryan);
            if (remainArrows > 0) {
                ryan[10] -= remainArrows;
            }
            return;
        }
        
        if (remainArrows > apeach[index]) {
            ryan[index] = apeach[index] + 1;
            backtrack(ryan, index + 1, remainArrows - ryan[index]);
            ryan[index] = 0;
        }
        
        backtrack(ryan, index + 1, remainArrows);
    }
    
    private static void calculateScore(int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;
        
        for (int i = 0; i < 11; i++) {
            if (ryan[i] > apeach[i]) {
                ryanScore += 10 - i;
            } else if (apeach[i] > 0) {
                apeachScore += 10 - i;
            }
        }

        int diff = ryanScore - apeachScore;
        if (diff > maxDiff) {
            maxDiff = diff;
            result = ryan.clone();
        } else if (diff == maxDiff && diff > 0) {
            if (isLowerScore(result, ryan)) {
                result = ryan.clone();
            }
        }
    }

    private static boolean isLowerScore(int[] arr1, int[] arr2) {
        for (int i = 10; i >= 0; i--) {
            if (arr1[i] != arr2[i]) {
                return arr2[i] > arr1[i];
            }
        }
        return false;
    }
}