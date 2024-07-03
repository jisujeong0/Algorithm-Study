import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
        
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a == 0) { 
				if(q.isEmpty()) { 
					sb.append(-1).append("\n");
				} else { 
					sb.append(q.poll()).append("\n");
				}
			} else { 
				for (int j = 0; j < a; j++) {
					int present = Integer.parseInt(st.nextToken());
					q.offer(present);
				}
			}
		}
        System.out.println(sb.toString());
	}
}