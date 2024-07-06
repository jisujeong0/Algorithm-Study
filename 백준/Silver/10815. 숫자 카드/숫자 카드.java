import java.io.*;
import java.util.*;

public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> card = new HashMap<>();
		for (int i=0; i<n; i++) {
			int j = Integer.parseInt(st.nextToken());
			card.put(j, 0);
		}
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
            if (card.get(num) != null) {
                sb.append("1");
            } else {
                sb.append("0");
            }
			sb.append(" ");
        }
        System.out.println(sb.toString());
	}

}