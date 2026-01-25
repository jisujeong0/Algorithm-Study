import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        // 시작 위치 삽입
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 밖인 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 벽인 경우
                if (maps[nx][ny] == 0) continue;

                // 이동 가능한 경우
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1; 
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}
