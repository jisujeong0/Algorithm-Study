import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int maxLength = 0;

        for (int len = 2; len <= str.length(); len += 2) {
            for (int start = 0; start <= str.length() - len; start++) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < len / 2; i++) {
                    sum1 += Integer.parseInt(String.valueOf(str.charAt(start + i)));
                    sum2 += Integer.parseInt(String.valueOf(str.charAt(start + len / 2 + i)));
                }
                // 합이 같으면 길이 갱신
                if (sum1 == sum2) {
                    maxLength = Math.max(maxLength, len);
                }
            }
        }

        System.out.println(maxLength);   
    }
}