import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<int[]> list = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        sb.append("1");
        int move = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n ; i++) {
            list.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!list.isEmpty()) {
            if (move > 0) {
                for (int x=1; x<move; x++) {
                    list.add(list.pollFirst());
                }
                int[] next = list.removeFirst();
                move = next[1];
                sb.append(" " + next[0]);
            } else {
                for (int x = move; x < -1; x++) {
                    list.addFirst(list.pollLast());
                }
                int[] next = list.removeLast();
                move = next[1];
                sb.append(" " + next[0]);
            }
        }
        System.out.println(sb);
    }
}