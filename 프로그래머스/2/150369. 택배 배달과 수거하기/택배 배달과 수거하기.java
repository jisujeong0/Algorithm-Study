import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L;
        // 그리디
        // n-1부터 반복, 마지막 인덱스부터 시작해서 탐색
        int dIdx = n - 1;
        int pIdx = n - 1;
        while(dIdx >= 0 || pIdx >= 0) {
            // 반복을 진행할 인덱스 위치 찾기
            while (dIdx >= 0 && deliveries[dIdx] == 0) dIdx--;
            while (pIdx >= 0 && pickups[pIdx] == 0) pIdx--;

            int point = Math.max(dIdx, pIdx);
            answer += (long)(point + 1) * 2L;
            
            int dCap = cap;  // deliveries의 cap
            int pCap = cap;
            // 배달
            while (dIdx >= 0 && dCap > 0) {
                if (deliveries[dIdx] > dCap) {
                    deliveries[dIdx] -= dCap;
                    dCap = 0;
                } else {
                    dCap -= deliveries[dIdx];
                    deliveries[dIdx] = 0;
                    dIdx--;
                }
            }
            // 수거
            while (pIdx >= 0 && pCap > 0) {
                if (pickups[pIdx] > pCap) {
                    pickups[pIdx] -= pCap;
                    pCap = 0;
                } else {
                    pCap -= pickups[pIdx];
                    pickups[pIdx] = 0;
                    pIdx--;
                }
            }
        }
        return answer;
    }
}