import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] out = new boolean[1002];

        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                out[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < 1002; i++) {
            if (!out[i]) {
                for (int j = 1; j < 1002; j++) {
                    if (!out[j]) {
                        for (int k = 1; k < 1002; k++) {
                            if (!out[k]) {
                                answer = Math.min(answer, Math.abs(n - i * j * k));
                            }
                        }
                    }
                }
            }
            if (answer == 0) break;
        }

        System.out.println(answer);
    }
}