import java.io.*;
import java.util.*;

public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 우선순위 큐
        PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            gift.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 1;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int kid = Integer.parseInt(st.nextToken());
            int left = gift.poll();
            if (left >= kid) {
               gift.add(left-kid); 
            } else {
                ans = 0;
                break;
            }   
        }
        System.out.println(ans);
    }
}