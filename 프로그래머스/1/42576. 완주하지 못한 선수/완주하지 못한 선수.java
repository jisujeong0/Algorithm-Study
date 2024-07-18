import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 중복이면 value 값 +1
        // value값만큼 key출력
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);    
        }
        for (String player : completion) {
            map.put(player, map.get(player) - 1);    
        }

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}