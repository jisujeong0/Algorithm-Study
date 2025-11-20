import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        // t 시점에 만료되는 서버 개수
        int[] expire = new int[n + k + 5];

        int active = 0; 
        int answer = 0;
        for (int t = 0; t < n; t++) {
            if (expire[t] > 0) {
                active -= expire[t];
            }
            int required = players[t] / m;
            if (active < required) {
                int add = required - active;  
                answer += add;
                active += add;

                expire[t + k] += add;
            }
        }
        return answer;
    }
}
