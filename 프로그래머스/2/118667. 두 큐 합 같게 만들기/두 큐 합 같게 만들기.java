import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long s1 = 0; 
        long s2 = 0;
        for (int q : queue1) {
            s1 += (long)q;
            q1.add(q);
        }
        for (int q : queue2) {
            s2 += (long)q;
            q2.add(q);
        }
        if ((s1 + s2) % 2 != 0) return -1;
        
        int limit = (queue1.length + queue2.length)*2;
        int cnt = 0;
        while (cnt < limit) {
            // 큐의 합을 비교해서 더 큰 큐에서 작은 큐로 원소를 이동
            if (s1 == s2) return cnt;
            if (s1 > s2) {
                int n = q1.poll();
                s1 -= (long)n;
                q2.add(n);
                s2 += (long)n;
            } else {
                int n = q2.poll();
                s2 -= (long)n;
                q1.add(n);
                s1 += (long)n;
            }
            cnt++;
        }
        return -1;
    }
}