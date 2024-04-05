import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        
        int box[] = new int[n+1];
        int sum[] = new int[n+1];
        
        int res = 0;
        for(int i=1; i<=n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            sum[i] = 1;
            for (int j=1; j<i; j++) {
                if(box[i] > box[j]) { 
                    sum[i] = Math.max(sum[i], sum[j] + 1);
                }
            }
            res = Math.max(res, sum[i]);
        }
        System.out.println(res);
    }
    
}
