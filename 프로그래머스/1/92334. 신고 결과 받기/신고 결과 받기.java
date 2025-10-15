import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> set = new HashSet<>(Arrays.asList(report));
        HashMap<String, Integer> map = new HashMap<>();  // 신고 당한 횟수
        for (String s : set) {
            String[] parts = s.split(" ");
            String reportUser = parts[1];
            map.put(reportUser, map.getOrDefault(reportUser, 0) + 1);
        }

        HashMap<String, Integer> result = new HashMap<>(); // 결과 메일을 받은 횟수
        for (String s : set) {
            String[] parts = s.split(" ");
            String user = parts[0];
            String reportUser = parts[1];
            if (map.get(reportUser) >= k) {
                result.put(user, result.getOrDefault(user, 0) + 1);
            } 
        }
        
        int[] answer = new int[id_list.length];
        for (int i=0; i<id_list.length; i++) {
            String id = id_list[i];
            if (result.containsKey(id)) answer[i] = result.get(id);
            else answer[i] = 0;
        }
        return answer;
    }
}