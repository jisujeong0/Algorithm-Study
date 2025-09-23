import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque();
        List<Integer> answer = new ArrayList();
        int cnt = 0;
        
        dq.add(arr[0]); 
        answer.add(arr[0]);
        for (int i = 1; arr.length > i; i++) {
            if (dq.peekLast() != arr[i]) {
                dq.addLast(arr[i]);
                answer.add(arr[i]);
                cnt++;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}