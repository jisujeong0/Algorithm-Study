import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int c: course) {
            // c의 개수만큼 조합해서 map에 저장
            Map<String, Integer> map = new HashMap<>();
            for (String order: orders) {
                String[] parts = order.split("");
                Arrays.sort(parts);
                comb(parts, 0, c, new StringBuilder(), map);
            }
            
            int max = 0;
            for (int value : map.values()) {
                if (value >= 2 && max < value) max = value;
            }
            if (max == 0) continue;
            
            for (String key : map.keySet()) {
                if (map.get(key) == max) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    // 백트래킹
    private void comb(String[] parts, int index, int c, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == c) {
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        for (int i=index; i<parts.length; i++) {
            sb.append(parts[i]);
            comb(parts, i+1, c, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}