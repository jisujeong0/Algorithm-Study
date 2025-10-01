import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] history = new int[n][n];    
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) {
                    history[i][j] = 0;
                }
                else {
                    int cnt = 0;
                    for (int k=0; k<gifts.length; k++) {
                        if (gifts[k].equals(friends[i] + " " + friends[j])) cnt++;
                    }
                    history[i][j] = cnt;
                    // System.out.println(friends[i] + " " + friends[j] + "의 개수:" + cnt);
                }
            }
        }
        // 다음 달에 받을 선물 개수 구하기
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if (i==j) continue;
                else {
                    if (history[i][j] > history[j][i]) {
                        cnt++;
                    } else if (history[i][j] == history[j][i]) {
                        int igifts = 0;   // i가 준 선물 개수 - 받은 선물
                        int jgifts = 0;   // j가 준 선물 개수 - 받은 선물
                        for (int k=0; k<n; k++) {
                            igifts += history[i][k];  
                            igifts -= history[k][i];
                            jgifts += history[j][k];  
                            jgifts -= history[k][j];
                        }
                        if (igifts > jgifts) {
                            cnt++;
                        }
                    }
                }
            }
            answer[i] = cnt;
        }
        return Arrays.stream(answer).max().getAsInt();
    }
}