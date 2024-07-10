import java.io.*;
import java.util.*;

public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		LinkedHashSet<String> studentSet = new LinkedHashSet<>();
		
		for (int i=0; i<l; i++) {
			String num = br.readLine();
            if (studentSet.contains(num)) {
				studentSet.remove(num);
			}
			studentSet.add(num);
        }

		List<String> res = new ArrayList<>(studentSet);
		int outputCount = Math.min(k, res.size());

		for (int i = 0; i < outputCount; i++) {
    		System.out.println(res.get(i));
		}
	}
}