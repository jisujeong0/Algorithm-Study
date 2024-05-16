import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);
            int result = 0;
            for(int k=0; k<n; k++) {
                int first = 0;
                int end = b.length - 1;
                int index = 0;

                while (first <= end) {
                    int mid = (first + end) / 2;
                    if (a[k] > b[mid]) {
                        first = mid + 1;
                        index = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
                result += index;
            }
            System.out.println(result);
        }
        

    }    
}
