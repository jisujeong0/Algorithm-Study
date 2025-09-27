import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> player = new HashMap<>();
        for (String p : participant) {
            // player에 p가 있으면 +1
            player.put(p, player.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            // player에 c가 있으면 -1
            player.put(c, player.get(c) - 1);
        }
        
        String answer = "";
        // 해시 순회하면서 value가 1 이상인 사람 출력
        // 제한사항: completion의 길이는 participant의 길이보다 1 작습니다.
        // 따라서 미완주자는 무조건 1명
        for (String p : player.keySet()) {
            if (player.get(p) > 0) {
                answer = p;
                break;
            }
        }
        return answer;    
    }
}