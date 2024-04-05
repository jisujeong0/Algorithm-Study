import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int dasom = Integer.parseInt(br.readLine());
        int[] votes = new int[n-1];
        
        for (int i = 0; i < n-1; i++) {
            votes[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(votes);
        
        int result = 0;
        while (true) {
            Arrays.sort(votes);
            if (votes[n-2] < dasom) break;
            result++;
            votes[n-2]--;
            dasom++;
        }
        
        System.out.println(result);
    }
    
}
