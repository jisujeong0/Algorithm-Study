import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());// 학생 수
		
		Queue<Integer> q = new LinkedList<>();	// 대기열
		Stack<Integer> s = new Stack<>();	//추가 대기열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		int num = 1;
		while (!q.isEmpty()) {
			if (q.peek() == num) {	
				q.poll();
				num++;
			} else if(!s.isEmpty() && s.peek() == num) {	
				s.pop();
				num++;
			} else {	
				s.push(q.poll());
			}
		}
		while (!s.isEmpty()) {	
			if (s.peek() == num) {
				s.pop();
				num++;
			} else {
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
		
	}
    
}
