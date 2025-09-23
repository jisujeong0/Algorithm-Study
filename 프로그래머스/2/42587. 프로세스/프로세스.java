import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            dq.addLast(new int[]{i, priorities[i]});
        }
        int order = 0;
        while(!dq.isEmpty()) {
            boolean hasHigher = false;  // deque 내에 더 높은 우선순위가 있는지
            int[] recent = dq.pollFirst();
            
            for (int[] process : dq) {
                if (process[1] > recent[1]) {
                    hasHigher = true;
                    break;
                } 
            }

            if(hasHigher) {
                dq.addLast(recent);    
            } else {
                order++;
                if (recent[0] == location) {
                    return order;
                }
            }
            
        }
        return -1;  // 출력되면 안 됨
    }
}