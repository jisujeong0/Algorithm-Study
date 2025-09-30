import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // min heap
        for (int s : scoville) {
            minHeap.offer(s);
        }
        int answer = 0;
        while (minHeap.size() > 1 && minHeap.peek() < K) {
            int n = minHeap.poll();
            int m = minHeap.poll();
            minHeap.offer(n + (m * 2));
            answer++;
        }
        if (minHeap.peek() >= K) return answer;
        else return -1;
    }
}