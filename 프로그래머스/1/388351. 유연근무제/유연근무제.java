import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int cnt = 0;
        for (int i=0; i<schedules.length; i++) {
            int day = startday;
            boolean receiveGift = true;
            int s = (schedules[i] / 100) * 60 + (schedules[i] % 100) + 10;
            for (int j=0; j<timelogs[i].length; j++) {
                if (day == 8) day = 1;
                if (day == 6 || day == 7) {
                    day++;
                    continue;
                }
                else {
                    int t = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);
                    if (s < t) {
                        receiveGift = false;
                        break;
                    }
                }
                day++;
            }
            if (receiveGift) cnt++;
        }
        return cnt;
    }
}