import java.util.*;
import java.io.*;

public class Main { // 퇴사
    // 최대 수익을 구해야 함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        int[] dp = new int[n+2];

        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=n; i>0; i--) {
            int nextDay = i+t[i];
            if (nextDay > n+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], p[i] + dp[nextDay]);
            }
        }

        System.out.println(dp[1]);
    }
}
