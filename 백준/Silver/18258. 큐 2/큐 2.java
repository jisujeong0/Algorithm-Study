import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer command;
		
		while(n-- > 0) {
			command = new StringTokenizer(br.readLine());
			
			switch(command.nextToken()) {	
			
			case "push":
				q.offer(Integer.parseInt(command.nextToken()));	
				break;
			case "pop" :
				Integer item1 = q.poll();	
				if(item1 == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(item1).append('\n');
				}
				break;
			case "size":	
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if(q.isEmpty()) {
					sb.append(1).append('\n');
				}
				else {
					sb.append(0).append('\n');
				}
				break;
			case "front":
				Integer item2 = q.peek();
				if(item2 == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(item2).append('\n');
				}
				break;
			case "back":
				Integer item3 = q.peekLast();	 
				if(item3 == null) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(item3).append('\n');
				}
				break;
			}
		}
		System.out.println(sb);
	}
}