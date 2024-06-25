import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			boolean isEmptyDeque = dq.isEmpty();
			switch (command) {
				case 1:
					int x = Integer.parseInt(st.nextToken());
					dq.addFirst(x);
					break;
				case 2:
					x = Integer.parseInt(st.nextToken());
					dq.addLast(x);
					break;
				case 3:
					if (!isEmptyDeque) sb.append(dq.removeFirst() + "\n");
					else sb.append(-1 + "\n");
					break;
				case 4:
					if (!isEmptyDeque) sb.append(dq.removeLast() + "\n");
					else sb.append(-1 + "\n");
					break;
				case 5:
					sb.append(dq.size() + "\n");
					break;
				case 6:
					if (!isEmptyDeque) sb.append(0 + "\n");
					else sb.append(1 + "\n");
					break;
				case 7:
					if (!isEmptyDeque) sb.append(dq.getFirst() + "\n");
					else sb.append(-1 + "\n");
					break;
				case 8:
					if (!isEmptyDeque) sb.append(dq.getLast() + "\n");
					else sb.append(-1 + "\n");
					break;
			}
		}
		System.out.println(sb);
	}
}