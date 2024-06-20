import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[101][101]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int stopX = Integer.parseInt(st.nextToken());
            int stopY = Integer.parseInt(st.nextToken());

            for (int j=startX; j<=stopX; j++) {
                for (int k=startY; k<=stopY; k++) {
                    arr[j][k] += 1;
                }
            }
        }

        int res = 0;
        for (int i=1; i<=100; i++) {
            for (int j=1; j<=100; j++) {
                if(arr[i][j]>m) res++;
            }
        }
        System.out.println(res);
    }
}