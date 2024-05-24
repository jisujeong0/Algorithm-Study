import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        int cnt = n;
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int prev = 0;
            // a-z까지의 알파벳 저장
            int[] alphabet = new int[26];

            for (int j = 0; j < s.length(); j++) {
                int now = s.charAt(j); 
                if (prev != now) {
                    // 알파벳이 이전에 나온적이 없을 경우
                    if (alphabet[now - 97] == 0) {
                        alphabet[now - 97] = 1;
                        prev = now;
                    } else {
                        cnt--;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

}