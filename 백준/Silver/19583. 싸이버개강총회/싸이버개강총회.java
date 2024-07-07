import java.io.*;
import java.util.*;

public class Main {   
	public static void main(String[] args) throws IOException {
		// : 제외하고 int 타입으로 변경 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken().replace(":", ""));
        int end = Integer.parseInt(st.nextToken().replace(":", ""));
        int streamEnd = Integer.parseInt(st.nextToken().replace(":", ""));

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nameSet = new HashSet<>();

        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            st = new StringTokenizer(str);
            int time = Integer.parseInt(st.nextToken().replace(":", ""));
            String name = st.nextToken();
            nameSet.add(name);

            if (time <= start) {
                before.add(name);
            }
            if (end <= time && time <= streamEnd) {
                after.add(name);
            }
        }

        int ans = 0;
        for (String name : nameSet) {
            if (before.contains(name) && after.contains(name)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}