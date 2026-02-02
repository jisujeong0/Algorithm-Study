import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words안에 target 있는지 체크
        if (!Arrays.asList(words).contains(target)) return 0;

        // 바꿀 수 있는 모든 단어들을 탐색 -> 최단 거리이므로 BFS
        boolean[] visited = new boolean[words.length];
        Queue<String> current = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        
        current.offer(begin);
        count.offer(0);
        
        while (!current.isEmpty()) {
            String c = current.poll();
            int cnt = count.poll();
            
            if (c.equals(target)) return cnt;
            
            for (int i=0; i<words.length; i++) {
                // 방문한 적 없고/변환 가능한지 확인
                if (!visited[i] && convertable(c, words[i])) {
                    current.offer(words[i]);
                    count.offer(cnt+1);
                    visited[i] = true;
                }
            }
            
        }
        return count.isEmpty()? 0 : count.poll();
        
    }
    
    private boolean convertable(String a, String b) {
        int cnt = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
    
}