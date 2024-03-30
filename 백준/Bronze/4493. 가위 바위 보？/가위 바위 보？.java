import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 4493번: 가위 바위 보?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());

            int p1_win = 0;
            int p2_win = 0;
            for (int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                String p2 = st.nextToken();

                if (p1.equals("R") && p2.equals("S") || p1.equals("S") && p2.equals("P") || p1.equals("P") && p2.equals("R")) {
                    p1_win += 1;
                } else if (p1.equals("S") && p2.equals("R") || p1.equals("P") && p2.equals("S") || p1.equals("R") && p2.equals("P")) {
                    p2_win += 1;
                } else { continue; }
            }
        
            if (p1_win > p2_win) { System.out.println("Player 1");}
            else if (p1_win < p2_win) { System.out.println("Player 2"); }
            else System.out.println("TIE");
        }
        
    }
}
