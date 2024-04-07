import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<String> result = new ArrayList<>();

        while (true) {
            st = new StringTokenizer(br.readLine());  
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int a2 = a * a;
            int b2 = b * b;
            int c2 = c * c;

            String answer = "wrong";

            int max2 = Math.max(a2, Math.max(b2, c2));
            int sum = a2 + b2 + c2 - max2;
            
            if (max2 == sum) {
                answer = "right";
            }
            result.add(answer);
        }
        // 결과 출력
        for (String res: result) {
            System.out.println(res);
        } 
    }
}