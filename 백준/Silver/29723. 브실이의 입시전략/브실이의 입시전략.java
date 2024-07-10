import java.io.*;
import java.util.*;

public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> subject = new HashMap<>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int grade = Integer.parseInt(st.nextToken());
			subject.put(name, grade);
		}

		int score = 0;
		for (int i=0; i<k; i++) {
			String str = br.readLine();
			score += subject.get(str);
			subject.remove(str);
		}
		// subject에서 m-k개만큼 최대 최소 구하기
		// 정렬?
		int max = score;
		int min = score;
		List<Integer> list = new ArrayList<>(subject.values());
		
		Collections.sort(list);
		for (int i=0; i<m-k; i++) {
			min += list.get(i);
		}

		Collections.sort(list, Collections.reverseOrder());
		for (int i=0; i<m-k; i++) {
			max += list.get(i);
		}
		System.out.println(min + " " + max);
	}
}