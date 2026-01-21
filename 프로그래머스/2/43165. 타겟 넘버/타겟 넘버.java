import java.util.*;

class Solution {
    static int len;
    static int target;
    static int answer = 0;
    static int[] numbers;
    
    public int solution(int[] numbers, int target) {     
        this.len = numbers.length;
        this.target = target;
        this.numbers = numbers;

        dfs(0, 0);
        return answer;
    }
    
    private void dfs(int depth, int sum) {
        if (depth == len) {
            if (sum == target) answer ++ ;
            return;
        }
        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum - numbers[depth]);
    }
}