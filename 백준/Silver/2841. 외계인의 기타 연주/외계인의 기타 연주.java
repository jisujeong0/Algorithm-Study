import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");;
		int n = Integer.parseInt(str[0]);
		int p = Integer.parseInt(str[1]);

		Stack<Integer>[] stack = new Stack[7];
		for (int i = 0; i <= 6; i++) {
			stack[i] = new Stack<>();
        }
        
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");;
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			while (!stack[a].isEmpty() && stack[a].peek() > b) {
				stack[a].pop();
				cnt++;
			}
			if (stack[a].empty() || (!stack[a].isEmpty() && stack[a].peek() < b)) {
				stack[a].push(b);
				cnt++;
			}
		}
		System.out.println(cnt + "\n");
    }
}