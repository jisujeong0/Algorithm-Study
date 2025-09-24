import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = prices.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            // 현재 가격이 이전 가격보다 떨어진 순간
            while (!dq.isEmpty() && prices[dq.peekLast()] > prices[i]) {
                int idx = dq.pollLast();
                answer[idx] = i - idx;
            }
            dq.addLast(i);
        }
        // 끝까지 가격이 떨어지지 않은 값 정리
        while (!dq.isEmpty()) {
            int idx = dq.pollLast();
            answer[idx] = n - 1 - idx;
        }
        return answer;
    }
}