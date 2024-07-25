import java.util.*;

class Solution {
    boolean solution(String s) {    
        Stack<Character> st = new Stack<>();
        
        boolean answer = true;
        for (char c : s.toCharArray()) {
            if (c == ')') {  
                if (st.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    if (st.peek() == '(') { st.pop(); }
                    else {
                        answer = false;
                        break;
                    }
                }
            } else {
                st.push(c);
            }
        }
        
        if (!st.isEmpty()) { answer = false; }
        return answer;
    }
}