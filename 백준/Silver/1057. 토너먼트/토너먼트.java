import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int res = 0;
        for (int i=0; i<n; i++) {
            res++;
        
            a = a/2 + a%2;
            b = b/2 + b%2;
            if (a==b) break;
        } 
        System.out.println(res);
    }
}