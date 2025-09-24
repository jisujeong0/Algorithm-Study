import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0; i<prices.length; i++) {
            dq.addLast(prices[i]);
        }
        int[] answer = new int[prices.length];
        int index = 0;
        while (!dq.isEmpty()) {
            int sec = 0;
            int recent = dq.pollFirst();
            if (dq.isEmpty()) {
                answer[index] = 0;
            } else {
                for (int price : dq) {
                    sec++;
                    if (price < recent) {
                        break;
                    }    
                }
                // dq 끝에 도달하면 알아서 answer에 return값 추가
                answer[index] = sec;
                index++;
            }       
        }
        return answer;
    }
}