import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		int t = Integer.parseInt(br.readLine());	
		while (t -- > 0) {
			HashMap<String, Integer> clothes = new HashMap<>();	
			int n = Integer.parseInt(br.readLine());	
			while (n-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); 
                
				String kind = st.nextToken();	
				if (clothes.containsKey(kind)) {
					clothes.put(kind, clothes.get(kind) + 1);
				} 
				else {
					clothes.put(kind, 1);
				}
			}
 
			int result = 1;
			for (int val : clothes.values()) {
				result *= (val + 1);
			}
			// 알몸인 상태 제외
			sb.append(result - 1).append('\n');
		}
		System.out.println(sb);
	}
 
}