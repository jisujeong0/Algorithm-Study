import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
		int arr[] = new int[10];
		for(char c : n.toCharArray()) {
			int num = c - '0';
            // 6과 9는 동일하게 처리
			if(num == 9) 
				num = 6;
			arr[num]++;
		}
		arr[6] = (arr[6] / 2) + (arr[6] % 2);

		Arrays.sort(arr); 
		System.out.println(arr[9]);
	}
}