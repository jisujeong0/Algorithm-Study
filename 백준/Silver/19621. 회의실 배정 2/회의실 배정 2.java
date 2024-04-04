import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
		int[] arr = new int[Math.max(2, n)];
		int[] dp = new int[Math.max(2, n)];
        
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int member = Integer.parseInt(st.nextToken());
			arr[i] = member;
		}
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
		}
		System.out.println(dp[n-1]);
	}
	
}