import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		char arr[] = br.readLine().toCharArray();
		int ans = 0;
		int tmp = 1;
		for (int i = 0; i < arr.length; i++) {
			char c1 = arr[i];
			if(c1 == '(' || c1 == '[') { 
				stack.add(c1);
                if (c1 == '(') tmp *= 2;
                else tmp *= 3;
			}
			else { 
				if(stack.isEmpty()) {
					ans = 0;
					break;
				} else {
					char c2 = stack.pop();
					if(c1 == ')') {
						if(c2 != '(') {
							ans = 0;
							break;
						} else {
							if(arr[i-1] == '(') {
                                ans += tmp;    
                            }
							tmp /= 2;
						}	
					} else {
						if(c2 != '[') {
							ans = 0;
							break;
						} else {
							if(arr[i-1] == '[') {
                                ans += tmp;    
                            }
							tmp /= 3;
						}
					}
				}			
			}
		}
		if(!stack.isEmpty()) {
            ans = 0;    
        }
		System.out.println(ans);
	}
}