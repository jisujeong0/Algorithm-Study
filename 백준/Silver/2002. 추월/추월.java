import java.io.*;
import java.util.*;

public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();

		for(int i=0; i<n; i++) {
            String input = br.readLine();
            map.put(input, i);
        }
        int[] out = new int[n];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            out[i] = map.get(input);
        }

		int res = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(out[i] > out[j]) {
                    res++;
                    break;
                }
            }
        }
		System.out.println(res);
	}
}