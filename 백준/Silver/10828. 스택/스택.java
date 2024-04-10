import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		
        Stack<Integer> stack = new Stack<Integer>();
        
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
            
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.empty()) { 
                        sb.append(stack.pop()).append("\n");
                    } else { sb.append(-1).append("\n"); }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(!stack.empty()) { 
                        sb.append(0).append("\n");
                    } else { sb.append(1).append("\n"); }
                    break;
                case "top":
                    if(!stack.empty()) {
                        sb.append(stack.peek()).append("\n");
                    } else { sb.append(-1).append("\n"); }
                    break;
            }
			
		}
        System.out.println(sb);
	}

}