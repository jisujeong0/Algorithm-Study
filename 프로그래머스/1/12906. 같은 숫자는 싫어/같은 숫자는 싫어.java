import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new ArrayDeque<>();
            
        q.addFirst(arr[0]);
        for (int i=1; i<arr.length; i++) {
            int n = arr[i];
            if (n != q.peekLast()) {  
                q.addLast(n);
            }
        }
        
        int cnt = q.size();
        int[] answer = new int[cnt];
        for (int i=0; i<cnt; i++) {
            answer[i] = q.pollFirst();
        }
        return answer;
    }
}