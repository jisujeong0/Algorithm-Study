import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int totalBags = -1;

        for (int i = 0; i <= n / 5; i++) {
            int num = n - (5 * i);

            if (num % 3 == 0) {
                int a = num / 3;
                totalBags = i + a;
            }
        }
        int minBags = totalBags;

        System.out.println(minBags);
    }
    
}