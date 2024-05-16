import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            int h = Integer.parseInt(st.nextToken());
            arr[i] = h;
        }
        Arrays.sort(arr);
        // snake와 arr 비교
        for(int i=0; i<arr.length; i++) {
            if ( arr[i] < snake || arr[i] == snake ) {
                snake += 1;
            }
        }
        System.out.println(snake);

    }    
}
