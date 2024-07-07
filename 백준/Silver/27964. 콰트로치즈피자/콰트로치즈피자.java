import java.io.*;
import java.util.*;

public class Main {   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashSet<String> cheese = new HashSet<>();
		for (int i=0; i<n; i++) {
			String topping = st.nextToken();
			if (topping.endsWith("Cheese")) {
				cheese.add(topping);
			}
		}

		int res = 0;
		for (String str : cheese) {
			res++;
		}
        
		if (res >= 4) {
			System.out.println("yummy");
		} else
			System.out.println("sad");
    }
}