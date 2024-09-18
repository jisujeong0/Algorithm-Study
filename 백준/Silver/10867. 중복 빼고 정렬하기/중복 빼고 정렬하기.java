import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Set<Integer> s = new HashSet<>();
        for (int i = 0 ; i < n ; i++){
            s.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arr = new ArrayList<>(s);
        Collections.sort(arr); 
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}