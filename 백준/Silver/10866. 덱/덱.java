import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (dq.size() == 0) sb.append(-1).append("\n");
                    else sb.append(dq.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    if (dq.size() == 0) sb.append(-1).append("\n");
                    else sb.append(dq.removeLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else sb.append(0).append("\n");
                    break;
                case "front":
                    if (dq.size() == 0) sb.append(-1).append("\n");
                    else sb.append(dq.getFirst()).append("\n");
                    break;
                case "back":
                    if (dq.size() == 0) sb.append(-1).append("\n");
                    else sb.append(dq.getLast()).append("\n");
                    break;
            }

        }
        System.out.print(sb);
    }
}