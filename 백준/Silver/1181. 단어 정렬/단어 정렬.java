import java.util.*;
import java.io.*;

public class Main {     // 단어 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i=0; i<n; i++) {
            arr[i] = br.readLine(); 
        }
        // 길이 순으로 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이 같으면 사전순 출력
                if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} 
				else {
					return s1.length() - s2.length();
				}
            }
        });
        for(int i=0; i<n; i++) {
			if(i!=0) {
				if(arr[i].compareTo(arr[i-1])!=0)
					System.out.println(arr[i]);
			}
			else
				System.out.println(arr[i]);
		}
	}
}

