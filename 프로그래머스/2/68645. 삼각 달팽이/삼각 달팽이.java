class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int num = 1;
        int x = -1, y = 0;

        for (int len = n; len > 0; len -= 3) {
            // 1. 아래
            for (int i = 0; i < len; i++) {
                x++;
                arr[x][y] = num++;
            }
            // 2. 오른쪽
            for (int i = 0; i < len - 1; i++) {
                y++;
                arr[x][y] = num++;
            }
            // 3. 위
            for (int i = 0; i < len - 2; i++) {
                x--;
                y--;
                arr[x][y] = num++;
            }
        }

        int total = n * (n + 1) / 2;
        int[] answer = new int[total];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}
