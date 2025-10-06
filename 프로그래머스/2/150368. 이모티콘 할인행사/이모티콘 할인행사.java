import java.util.*;

class Solution {
    static int n, m;
    static int maxTotalCost = 0;
    static int maxSubscribe = 0;
    static int[] discounts = {10, 20, 30, 40};
        
    public int[] solution(int[][] users, int[] emoticons) {
        this.n = users.length;
        this.m = emoticons.length;
        
        int[] percent = new int[m]; // 현재 할인율 조합
        dfs(0, users, emoticons, percent);

        return new int[]{maxSubscribe, maxTotalCost};
    }
    
    static void dfs(int depth, int[][] users, int[] emoticons, int[] percent) {
        if (depth == m) {
            calculate(users, emoticons, percent);
            return;
        }
        for (int d : discounts) {
            percent[depth] = d;
            dfs(depth + 1, users, emoticons, percent);
        }
    }
    
    static void calculate(int[][] users, int[] emoticons, int[] percent) {
        int totalCost = 0;
        int subscribe = 0;
        for (int i=0; i<n; i++) {
            int cost = 0;
            for (int j=0; j<m; j++) {
                if (users[i][0] <= percent[j]) {
                    cost += emoticons[j] * (100 - percent[j]) / 100;
                } 
                if (cost >= users[i][1]) {
                    subscribe++;
                    cost = 0;
                    break;
                }
            }
            totalCost += cost;
        }
        if (maxSubscribe < subscribe) {
            maxSubscribe = subscribe;
            maxTotalCost = totalCost;
        }
        else if (maxSubscribe == subscribe && maxTotalCost < totalCost) maxTotalCost = totalCost;
    }
    
}