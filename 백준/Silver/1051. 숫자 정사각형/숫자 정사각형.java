import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
       
        int ans = 1;
		char[][] arr = new char[n][m];
		for(int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 1; i+k < n&&j + k < m; k++) {	
					if(arr[i][j] == arr[i+k][j] && arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j+k])
						ans = Math.max(ans, (k+1)*(k+1));
				}
            }
        }
		System.out.println(ans);
	}
}