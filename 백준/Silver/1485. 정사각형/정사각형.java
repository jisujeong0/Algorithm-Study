import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
    
        for (int i=0; i<t; i++) {
            int[] x = new int[4];
            int[] y = new int[4];
            for (int j=0; j<4; j++) {
                st = new StringTokenizer(br.readLine());
                x[j] = Integer.parseInt(st.nextToken());
                y[j] = Integer.parseInt(st.nextToken());
            }

            if (isSquare(x, y)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    public static boolean isSquare(int[] x, int[] y) {
        int[] d = new int[6];
        int k = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                d[k] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                k++;
            }
        }

        Arrays.sort(d);
        return (d[0] > 0 &&        
                d[0] == d[1] &&    
                d[1] == d[2] &&
                d[2] == d[3] &&
                d[4] == d[5] &&    
                d[0] * 2 == d[4]);
    }

}