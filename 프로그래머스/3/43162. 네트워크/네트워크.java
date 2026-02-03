import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
    
        int network = 0;
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                network++;
            }
        }
        
        return network;
    }
    
    // DFS
    private void dfs(int i, int[][] computers) {
        visited[i] = true;
        
        for (int j=0; j<computers.length; j++) {
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(j, computers);
            }
        }    
    }
}