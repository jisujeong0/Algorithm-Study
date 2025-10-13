import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] types = {"R", "T", "F", "C", "M", "J", "A", "N"};
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String t : types) {
            map.put(t, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            String[] str = survey[i].split("");
            
            String type = "";
            int point = 0;
            switch (choices[i]) {
                case 1: type = str[0]; point = 3; break;
                case 2: type = str[0]; point = 2; break;
                case 3: type = str[0]; point = 1; break;
                case 4: continue;
                case 5: type = str[1]; point = 1; break;
                case 6: type = str[1]; point = 2; break;
                case 7: type = str[1]; point = 3; break;
                default: break;
            }
            map.put(type, map.get(type) + point);
        }
    
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < types.length; i += 2) {
            String t1 = types[i];
            String t2 = types[i + 1];
            if (map.get(t1) > map.get(t2)) answer.append(t1);
            else if (map.get(t1) < map.get(t2)) answer.append(t2);
            else answer.append(t1.compareTo(t2) < 0 ? t1 : t2); 
        }
    
        return answer.toString();
    }
}