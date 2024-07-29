import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        
        boolean[][] pairs = new boolean[n+1][n+1];
        for(int i=0; i<m; i++){
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            pairs[a][b] = true;
            pairs[b][a] = true;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for(int j=i+1; j<=n; j++){
                if(pairs[i][j]) continue; 
                for (int k = j + 1; k <= n; k++) {
                    if(!pairs[j][k] && !pairs[k][i]){ 
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}